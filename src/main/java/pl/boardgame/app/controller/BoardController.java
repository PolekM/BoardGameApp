package pl.boardgame.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.boardgame.app.dto.GameFilter;
import pl.boardgame.app.entity.Board;
import pl.boardgame.app.entity.Publisher;
import pl.boardgame.app.service.BoardService;

import java.util.List;
import java.util.Optional;

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
    @PostMapping(value = "/games/new")
    public void addGame(@RequestBody Board board){
        boardService.addGame(board);
    }

    @DeleteMapping(value = "/games/removeGame/{id}")
    public void deleteGame(@PathVariable("id") Long id){
        boardService.deleteGame(id);
    }

    @GetMapping(value = "/games/publisher/{id}")
    public List<Board> getGamesByPublisherId(Publisher id){
        return boardService.getGamesByPublisherId(id);
    }

    @GetMapping(value = "/games/randomGame")
    public Board randomGame(){
        return boardService.randomGame();
    }

}
