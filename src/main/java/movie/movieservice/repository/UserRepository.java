package movie.movieservice.repository;

import lombok.RequiredArgsConstructor;
import movie.movieservice.domain.MovieWorker;
import movie.movieservice.domain.User;
import movie.movieservice.domain.Worker;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    @PersistenceContext
    private final EntityManager em;

    public Long save(User user){
        em.persist(user);
        em.persist(user);
        return user.getId();
    }

    public void update(Long userId, String name) {
        TypedQuery<User> query = em.createQuery("select u from User u where n.user_id=:userId", User.class);
        query.setParameter("userId", userId);
        User result = query.getSingleResult();
        result.setEditTime(LocalDateTime.now());
        result.editUserName(name);
    }

    public void delete(Long userId) {
        User user = em.find(User.class, userId);
        em.remove(user);
    }
}
