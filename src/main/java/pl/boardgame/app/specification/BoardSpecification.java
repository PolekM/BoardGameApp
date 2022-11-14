package pl.boardgame.app.specification;

import org.springframework.data.jpa.domain.Specification;
import pl.boardgame.app.dto.GameFilter;
import pl.boardgame.app.entity.Board;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import static java.util.Optional.*;

public class BoardSpecification{
    public static Specification<Board> boardSpecification(GameFilter gameFilter) {
        return (Root<Board> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            List<Predicate> predicateList = new ArrayList<>();
            ofNullable(gameFilter.getBoardName()).ifPresent(val -> predicateList.add(cb.like(cb.lower(root.get("boardName")),val.toLowerCase())));
            ofNullable(gameFilter.getMaxPlayer()).ifPresent(val -> predicateList.add(cb.lessThanOrEqualTo(root.get("maxPlayer"),val)));
            ofNullable(gameFilter.getAveragePlayTime()).ifPresent(val -> predicateList.add(cb.lessThanOrEqualTo(root.get("averagePlayTime"),val)));
            return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
        };
    }
}
