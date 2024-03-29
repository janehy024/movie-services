package movie.movieservice.repository;

import movie.movieservice.domain.Movie;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    public void saveAll(List<Movie> movies) {

        int batchSize = 50;

        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            em.persist(movie);

            if (i > 0 && i % batchSize == 0) {
                em.flush();
                em.clear();
            }
        }

    }

}
