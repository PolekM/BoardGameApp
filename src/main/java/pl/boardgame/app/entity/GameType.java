package pl.boardgame.app.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class GameType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;

    @OneToMany(mappedBy = "gameTypelist",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Board> boardGames;

    public GameType() {
    }

    public GameType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String gameType) {
        this.type = gameType;
    }
}
