package movie.movieservice.repository;

import lombok.RequiredArgsConstructor;
import movie.movieservice.domain.MovieWorker;
import movie.movieservice.domain.Worker;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor
public class WorkerRepository {

    @PersistenceContext
    private final EntityManager em;

    public Long save(MovieWorker movieWorker, Worker worker){
        em.persist(movieWorker);
        em.persist(worker);
        return movieWorker.getId();
    }

}
