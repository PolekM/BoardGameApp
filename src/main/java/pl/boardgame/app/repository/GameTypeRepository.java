package pl.boardgame.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.boardgame.app.entity.GameType;

@Repository
public interface GameTypeRepository extends JpaRepository<GameType,Long> {

    GameType findByType(String type);
}
