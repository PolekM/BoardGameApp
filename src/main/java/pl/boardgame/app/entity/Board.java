package pl.boardgame.app.entity;



import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
public class Board implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String boardName;
    private String description;
    private int averagePlayTime;
    private int minPlayer;
    private int maxPlayer;

    @ManyToOne
    @JoinColumn(name = "publisher_id",nullable = false)
    private Publisher publisherId;

    @ManyToOne
    @JoinColumn(name = "game_type_id",nullable = false)
    private GameType gameTypelist;

//    @OneToMany(mappedBy = "boardId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<UserGame> userGame;

}
