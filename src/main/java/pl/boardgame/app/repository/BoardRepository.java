package pl.boardgame.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.boardgame.app.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long>, JpaSpecificationExecutor<Board> {
}
