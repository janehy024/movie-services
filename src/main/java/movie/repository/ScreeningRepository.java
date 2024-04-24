package movie.repository;


import movie.domain.Movie;
import movie.domain.Screen;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ScreeningRepository {
    @PersistenceContext
    private final EntityManager em;

    public ScreeningRepository(EntityManager em) {
        this.em = em;
    }

    public Long save(Screen screen){
        em.persist(screen);
        return screen.getId();
    }

    public Screen findOne(Long screenId) {
        return em.find(Screen.class, screenId);
    }
    public Screen findByTheaterId(Long theaterId) {
        return em.find(Screen.class, theaterId);
    }
}
