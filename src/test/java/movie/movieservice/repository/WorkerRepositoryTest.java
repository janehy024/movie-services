package movie.movieservice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class WorkerRepositoryTest {

    @Autowired
    WorkerRepository workerRepository;

    @Test
    @Rollback(false)
    public void testActor() throws Exception {
    }

}