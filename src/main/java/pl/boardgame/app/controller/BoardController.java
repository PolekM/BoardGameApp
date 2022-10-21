package pl.boardgame.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.boardgame.app.entity.Board;
import pl.boardgame.app.service.BoardService;

import java.util.List;

@RestController
@RequestMapping
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping(value = "/games")
    public List<Board> getGames()
    {
        return boardService.getGames();
    }

}
