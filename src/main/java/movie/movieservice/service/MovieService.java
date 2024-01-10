package movie.movieservice.service;

import movie.movieservice.domain.Movie;
import movie.movieservice.domain.MovieWorker;
import movie.movieservice.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void showMovieWithMovieId(Long movieId) {
        Movie movie = movieRepository.findOne(movieId);
        List<MovieWorker> movieWorkers = movie.getMovieWorkers();

        System.out.println(movie);
        movieWorkers.stream().forEach(mw -> System.out.print(mw.getWorkers().getName() + " "));
    }
}
