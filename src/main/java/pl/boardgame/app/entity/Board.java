package pl.boardgame.app.entity;

import javax.persistence.*;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String boardName;
    private String description;
    private int averagePlayTime;
    private int minPlayer;
    private int maxPlayer;



    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "publisher_id",nullable = false)
    private Publisher publisherId;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "game_type_id",nullable = false)
    private GameType gameTypelist;



    private Board(String boardName, String description, int averagePlayTime, int minPlayer, int maxPlayer, Publisher publisherId, GameType gameTypelist) {
        this.boardName = boardName;
        this.description = description;
        this.averagePlayTime = averagePlayTime;
        this.minPlayer = minPlayer;
        this.maxPlayer = maxPlayer;
        this.publisherId = publisherId;
        this.gameTypelist = gameTypelist;
    }

    public Board() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAveragePlayTime() {
        return averagePlayTime;
    }

    public void setAveragePlayTime(int averagePlayTime) {
        this.averagePlayTime = averagePlayTime;
    }

    public int getMinPlayer() {
        return minPlayer;
    }

    public void setMinPlayer(int minPlayer) {
        this.minPlayer = minPlayer;
    }

    public int getMaxPlayer() {
        return maxPlayer;
    }

    public void setMaxPlayer(int maxPlayer) {
        this.maxPlayer = maxPlayer;
    }

    public Publisher getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Publisher publisherId) {
        this.publisherId = publisherId;
    }

    public GameType getGameTypelist() {
        return gameTypelist;
    }

    public void setGameTypelist(GameType gameTypelist) {
        this.gameTypelist = gameTypelist;
    }

    public static class BoardGameBuilder {
        private String boardName;
        private String description;
        private int averagePlayTime;
        private int minPlayer;
        private int maxPlayer;
        private Publisher publisherId;
        private GameType gameType;

        public BoardGameBuilder setBoardName(String boardName) {
            this.boardName = boardName;
            return this;
        }

        public BoardGameBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public BoardGameBuilder setAveragePlayTime(int averagePlayTime) {
            this.averagePlayTime = averagePlayTime;
            return this;
        }

        public BoardGameBuilder setMinPlayer(int minPlayer) {
            this.minPlayer = minPlayer;
            return this;
        }

        public BoardGameBuilder setMaxPlayer(int maxPlayer) {
            this.maxPlayer = maxPlayer;
            return this;
        }

        public BoardGameBuilder setPublisherId(Publisher publisherId) {
            this.publisherId = publisherId;
            return this;
        }

        public BoardGameBuilder setGameTypeList(GameType gameType) {
            this.gameType = gameType;
            return this;
        }

        public Board build() {
            return new Board(boardName, description, averagePlayTime, minPlayer, maxPlayer, publisherId, gameType);
        }
    }


}
