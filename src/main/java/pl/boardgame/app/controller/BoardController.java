package pl.boardgame.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.boardgame.app.dto.GameFilter;
import pl.boardgame.app.dto.board.BoardDto;
import pl.boardgame.app.dto.board.BoardSaveDto;
import pl.boardgame.app.entity.Board;
import pl.boardgame.app.entity.Publisher;
import pl.boardgame.app.exception.GameTypeException;
import pl.boardgame.app.exception.PublisherException;
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
    public List<BoardDto> getGames() {
        return boardService.getGames();
    }

    @PostMapping(value = "/games/search")
    public List<Board> getGames(@RequestBody GameFilter gameFilter) {
        return boardService.getGames(gameFilter);
    }

   // @Transactional
    @PostMapping(value = "/games/new")
    public void addGame(@RequestBody BoardSaveDto boardSaveDto) throws PublisherException, GameTypeException {
        boardService.addGame(boardSaveDto);
    }

    @DeleteMapping(value = "/games/removeGame/{id}")
    public void deleteGame(@PathVariable("id") Long id) {
        boardService.deleteGame(id);
    }

    @GetMapping(value = "/games/publisher/{id}")
    public List<Board> getGamesByPublisherId(Publisher id) {
        return boardService.getGamesByPublisherId(id);
    }

    @GetMapping(value = "/games/randomGame")
    public Board randomGame() {
        return boardService.randomGame();
    }

}
