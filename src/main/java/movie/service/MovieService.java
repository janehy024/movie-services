package movie.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import movie.domain.Movie;
import movie.domain.MovieWorker;
import movie.domain.QMovie;
import movie.domain.Worker;
import movie.dto.MovieSearchDTO;
import movie.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void showMovieByMovieId(Long movieId) {
        Movie movie = movieRepository.findOne(movieId);
        List<MovieWorker> movieWorkers = movie.getMovieWorkers();

        System.out.println(movie);
        movieWorkers.stream().forEach(mw -> System.out.print(mw.getWorkers().getName() + " "));
    }

    private static BooleanExpression movieOpeningDate(MovieSearchDTO param) {
        if (param.getOpeningDate()==null || param.getOpeningDate().equals("")) {
            System.out.println("openingDate is null");
            return null;
        }
        return QMovie.movie.openingDate.between(param.getOpeningDate(), param.getOpeningDate());
    }

    private static BooleanExpression movieDirectorContain(MovieSearchDTO param) {
        if (param.getDirector() == null || param.getDirector().equals("")) {
            System.out.println("Director is null");
            return null;
        }
        return QMovie.movie.movieWorkers.any().workers.name.eq(param.getDirector().getName());
    }

    private static BooleanExpression movieActorContain(MovieSearchDTO param) {
        if (param.getActor() == null || param.getActor().equals("")) {
            System.out.println("Actor is null");
            return null;
        }
        return QMovie.movie.movieWorkers.any().workers.name.eq(param.getActor().getName());
    }

    public void showMovieByDirectorOrActorOrOpeningDate(Worker director, Worker actor, Date openingDate) throws Exception {
        MovieSearchDTO param = new MovieSearchDTO(director, actor, openingDate);
        nullCheck(param);

        BooleanExpression directorContain = movieDirectorContain(param);
        BooleanExpression actorContain = movieActorContain(param);
        BooleanExpression openingDateEq = movieOpeningDate(param);

        List<Movie> movies =movieRepository
                .findByDirectorOrActorOrOpeningDate(param, directorContain, actorContain, openingDateEq);

        movies.stream().forEach(System.out::println);
    }

    private static void nullCheck(MovieSearchDTO param) throws Exception {
        if ((param.getOpeningDate() == null) & (param.getDirector() == null) & (param.getActor() == null)) {
            throw new Exception("검색 값이 없습니다.");
        }
    }
}
