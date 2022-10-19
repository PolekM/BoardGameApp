package pl.boardgame.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.boardgame.app.entity.UserGame;

@Repository
public interface UserGameRepository extends JpaRepository<UserGame,Long> {
}
