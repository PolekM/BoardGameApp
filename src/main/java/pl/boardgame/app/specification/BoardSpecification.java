package pl.boardgame.app.specification;

import org.springframework.data.jpa.domain.Specification;
import pl.boardgame.app.dto.GameFilter;
import pl.boardgame.app.entity.Board;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import static java.util.Optional.*;

public class BoardSpecification{
    public static Specification<Board> boardSpecification(GameFilter gameFilter) {
        return (root, query, cb) -> {
            List<Predicate> predicateList = new ArrayList<>();
            ofNullable(gameFilter.getBoardName()).ifPresent(val -> predicateList.add(cb.like(cb.lower(root.get("boardName")),val.toLowerCase())));
            return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
        };
    }
}
