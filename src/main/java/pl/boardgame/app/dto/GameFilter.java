package pl.boardgame.app.dto;

import lombok.Getter;

@Getter
public class GameFilter {

    private String boardName;
    private String description;
    private int averagePlayTime;
    private int minPlayer;
    private int maxPlayer;

}
