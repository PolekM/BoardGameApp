package pl.boardgame.app.service.imp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.boardgame.app.dto.GameFilter;
import pl.boardgame.app.dto.board.BoardDto;
import pl.boardgame.app.dto.board.BoardSaveDto;
import pl.boardgame.app.entity.Board;
import pl.boardgame.app.entity.GameType;
import pl.boardgame.app.entity.Publisher;
import pl.boardgame.app.exception.GameTypeException;
import pl.boardgame.app.exception.PublisherException;
import pl.boardgame.app.repository.BoardRepository;
import pl.boardgame.app.repository.GameTypeRepository;
import pl.boardgame.app.repository.PublisherRepository;
import pl.boardgame.app.service.BoardService;
import pl.boardgame.app.specification.BoardSpecification;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class BoardServiceImp implements BoardService {

    private final BoardRepository boardRepository;
    private final PublisherRepository publisherRepository;
    private final GameTypeRepository gameTypeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BoardServiceImp(BoardRepository boardRepository,PublisherRepository publisherRepository,GameTypeRepository gameTypeRepository, ModelMapper modelMapper) {
        this.boardRepository = boardRepository;
        this.modelMapper = modelMapper;
        this.publisherRepository = publisherRepository;
        this.gameTypeRepository = gameTypeRepository;
    }

    @Override
    public List<BoardDto> getGames() {
        return boardRepository.findAll().stream().map(this::BoardDTO).collect(Collectors.toList());
    }

    @Override
    public List<Board> getGames(GameFilter gameFilter) {
        return boardRepository.findAll(BoardSpecification.boardSpecification(gameFilter));
    }

    @Override
    public void addGame(BoardSaveDto boardSaveDto) throws PublisherException, GameTypeException {
        boardRepository.save(BoardSaveDto(boardSaveDto));
    }

    @Override
    public void deleteGame(Long id) {
        boardRepository.deleteById(id);
    }

    @Override
    public List<Board> getGamesByPublisherId(Publisher id) {
        return boardRepository.findAllByPublisherId(id);
    }

    @Override
    public Board randomGame() {
        Random random = new Random();
        List<Board> allGame = boardRepository.findAll();
        Board game;
        try {
            game = allGame.get(random.nextInt(allGame.size()));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
            game = allGame.get(1);
        }
        return game;
    }

    public BoardDto BoardDTO(Board board) {
        //modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(board, BoardDto.class);
    }

    public Board BoardSaveDto(BoardSaveDto boardSaveDto) throws PublisherException, GameTypeException {
        Board board = new Board();
        Publisher publisher = publisherRepository.findByName(boardSaveDto.getPublisherName());
        if(publisher ==null){
            throw new PublisherException("W bazie nie występuje taki wydawca");
        }
        GameType type = gameTypeRepository.findByType(boardSaveDto.getGameType());
        if(type==null){
            throw new GameTypeException("W Bazie nie występuje taki typ gry");
        }

        board.setBoardName(boardSaveDto.getBoardName());
        board.setDescription(boardSaveDto.getDescription());
        board.setAveragePlayTime(boardSaveDto.getAveragePlayTime());
        board.setMinPlayer(boardSaveDto.getMinPlayer());
        board.setMaxPlayer(boardSaveDto.getMaxPlayer());
        board.setPublisherId(publisher);
        board.setGameTypelist(type);
        return board;
    }
}
