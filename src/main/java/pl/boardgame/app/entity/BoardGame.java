package pl.boardgame.app.entity;

import javax.persistence.*;

@Entity
public class BoardGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String boardName;
    private String description;
    private int averagePlayTime;
    private int minPlayer;
    private int maxPlayer;
    @ManyToOne
    private Publisher publisherId;
    @ManyToOne
    private Game gameTypeId;

    private BoardGame(String boardName, String description, int averagePlayTime, int minPlayer, int maxPlayer, Publisher publisherId, Game gameTypeId) {
        this.boardName = boardName;
        this.description = description;
        this.averagePlayTime = averagePlayTime;
        this.minPlayer = minPlayer;
        this.maxPlayer = maxPlayer;
        this.publisherId = publisherId;
        this.gameTypeId = gameTypeId;
    }

    public BoardGame() {
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

    public Game getGameTypeId() {
        return gameTypeId;
    }

    public void setGameTypeId(Game gameTypeId) {
        this.gameTypeId = gameTypeId;
    }
    public static class BoardGameBuilder {
        private String boardName;
        private String description;
        private int averagePlayTime;
        private int minPlayer;
        private int maxPlayer;
        private Publisher publisherId;
        private Game gameTypeId;

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

        public BoardGameBuilder setGameTypeId(Game gameTypeId) {
            this.gameTypeId = gameTypeId;
            return this;
        }

        public BoardGame build() {
            return new BoardGame(boardName, description, averagePlayTime, minPlayer, maxPlayer, publisherId, gameTypeId);
        }
    }


}
