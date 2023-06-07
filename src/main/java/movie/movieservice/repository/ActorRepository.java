package movie.movieservice.repository;

import lombok.RequiredArgsConstructor;
import movie.movieservice.domain.Actor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor
public class ActorRepository {

    @PersistenceContext
    private final EntityManager em;

    public Long save(Actor actor){
        em.persist(actor);
        return actor.getId();
    }

    public Actor findOne(Long id){ return em.find(Actor.class, id); }
}
