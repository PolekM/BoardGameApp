package pl.boardgame.app.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Publisher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "publisherId",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Board> boardGames;

    public Publisher() {
    }

    public Publisher(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
