package pl.boardgame.app.dto;

import lombok.Getter;

@Getter
public class GameFilter {

    private String boardName;
    private Integer averagePlayTime;
    private Integer minPlayer;
    private Integer maxPlayer;

}
