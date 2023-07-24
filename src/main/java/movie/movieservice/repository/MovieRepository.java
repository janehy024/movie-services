package movie.movieservice.repository;

import movie.movieservice.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MovieRepository {

    @PersistenceContext
    private final EntityManager em;

    public MovieRepository(EntityManager em) {
        this.em = em;
    }

    public String save(Movie movie){
        em.persist(movie);
        return movie.getId();
    }

    public Movie findOne(Long id){ return em.find(Movie.class, id); }
}
