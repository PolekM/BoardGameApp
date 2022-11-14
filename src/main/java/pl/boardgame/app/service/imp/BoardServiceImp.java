package pl.boardgame.app.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.boardgame.app.dto.GameFilter;
import pl.boardgame.app.entity.Board;
import pl.boardgame.app.repository.BoardRepository;
import pl.boardgame.app.service.BoardService;
import pl.boardgame.app.specification.BoardSpecification;

import java.util.List;

@Service
public class BoardServiceImp implements BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardServiceImp(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public List<Board> getGames() {
        return boardRepository.findAll();
    }

    @Override
    public List<Board> getGames(GameFilter gameFilter) {
        return boardRepository.findAll(BoardSpecification.boardSpecification(gameFilter));
    }

    @Override
    public void addGame(Board board) {
        boardRepository.save(board);
    }
}
