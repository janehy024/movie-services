package movie.movieservice.repository;

import movie.api.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MovieRepositoryTest {

    @Autowired MovieService movieService;
    @Autowired MovieRepository movieRepository;


    @Test
    @Rollback(false)
    public void testMovie() throws Exception {
        movieService.updateMovies();

    }

}