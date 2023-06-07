package movie.movieservice.repository;

import movie.movieservice.domain.Actor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ActorRepositoryTest {

    @Autowired
    ActorRepository actorRepository;

    @Test
    @Rollback(false)
    public void testActor() throws Exception {
        Actor actor = new Actor();
        actor.setHeight(50);
        actor.setInstagram("aa");
        //actor.setId(1L);

        Long id = actorRepository.save(actor);
        System.out.println("id = " + id);


    }

}