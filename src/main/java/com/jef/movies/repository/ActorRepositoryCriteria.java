package com.jef.movies.repository;

import com.jef.movies.entity.Actor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@AllArgsConstructor
public class ActorRepositoryCriteria {

    private final EntityManager em;

    public List<Actor> getActorWithFirstNamePrefix(String prefixFirstName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);

        Root<Actor> actor = cq.from(Actor.class);
        Predicate actorFirstName = cb.like(actor.get("firstName"), prefixFirstName + "%");
        cq.where(actorFirstName);

        TypedQuery<Actor> query = em.createQuery(cq);
        return query.getResultList();
    }
}
