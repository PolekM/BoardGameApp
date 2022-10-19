package pl.boardgame.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.boardgame.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
