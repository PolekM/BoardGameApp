package pl.boardgame.app.service;

import org.springframework.stereotype.Service;
import pl.boardgame.app.entity.Board;
import pl.boardgame.app.repository.BoardRepository;

import java.util.List;


public interface BoardService {



    List<Board> getGames();
}