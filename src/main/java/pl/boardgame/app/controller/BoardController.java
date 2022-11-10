package pl.boardgame.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.boardgame.app.dto.GameFilter;
import pl.boardgame.app.entity.Board;
import pl.boardgame.app.service.BoardService;

import java.util.List;

@RestController
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping(value = "/games")
    public List<Board> getGames() {
        return boardService.getGames();
    }

    @PostMapping(value = "/games/search")
    public List<Board> getGames(@RequestBody GameFilter gameFilter){
        return boardService.getGames(gameFilter);
    }
}
