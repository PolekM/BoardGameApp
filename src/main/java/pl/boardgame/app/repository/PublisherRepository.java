package pl.boardgame.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.boardgame.app.entity.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Long> {

    Publisher findByName(String name);
}
