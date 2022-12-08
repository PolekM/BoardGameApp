package pl.boardgame.app.dto.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.boardgame.app.entity.GameType;
import pl.boardgame.app.entity.Publisher;

@Getter
@Setter
public class BoardDto {

    public String boardName;
    public String description;
    public int averagePlayTime;
    public int minPlayer;
    public int maxPlayer;
    public String gameType;
    public String publisherName;



}
