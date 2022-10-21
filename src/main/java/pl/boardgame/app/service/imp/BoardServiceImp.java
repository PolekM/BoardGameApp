package pl.boardgame.app.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.boardgame.app.entity.Board;
import pl.boardgame.app.repository.BoardRepository;
import pl.boardgame.app.service.BoardService;

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
}