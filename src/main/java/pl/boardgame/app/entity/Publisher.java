package pl.boardgame.app.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
public class Publisher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    @OneToMany(mappedBy = "publisherId",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<Board> boardGames;


}
