package pl.boardgame.app.service;

import pl.boardgame.app.dto.GameFilter;
import pl.boardgame.app.dto.board.BoardDto;
import pl.boardgame.app.dto.board.BoardSaveDto;
import pl.boardgame.app.entity.Board;
import pl.boardgame.app.entity.Publisher;
import pl.boardgame.app.exception.GameTypeException;
import pl.boardgame.app.exception.PublisherException;

import java.util.List;


public interface BoardService {


    List<BoardDto> getGames();

    List<Board> getGames(GameFilter gameFilter);

    void addGame(BoardSaveDto boardSaveDto) throws PublisherException, GameTypeException;

    void deleteGame(Long id);

    List<Board> getGamesByPublisherId(Publisher id);

    Board randomGame();
}
