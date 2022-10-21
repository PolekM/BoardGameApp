package pl.boardgame.app.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserGame implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board boardId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    public UserGame() {
    }

    public UserGame(Board board_id, User user_id) {
        this.boardId = board_id;
        this.userId = user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Board getBoardId() {
        return boardId;
    }

    public void setBoardId(Board board_id) {
        this.boardId = board_id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User user_id) {
        this.userId = user_id;
    }
}
