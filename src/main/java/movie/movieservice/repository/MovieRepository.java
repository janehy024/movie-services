package movie.movieservice.repository;

import lombok.RequiredArgsConstructor;
import movie.movieservice.domain.Actor;
import movie.movieservice.domain.Movie;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor
public class MovieRepository {

    @PersistenceContext
    private final EntityManager em;

    public String save(Movie movie){
        em.persist(movie);
        return movie.getId();
    }

    public Actor findOne(Long id){ return em.find(Actor.class, id); }
}
