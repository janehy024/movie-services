package movie.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import movie.domain.Movie;
import movie.domain.QMovie;
import movie.domain.QMovieWorker;
import movie.dto.MovieSearchDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;


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

    public Movie findOne(String movieId) {
        String jpql = "SELECT m FROM movie m WHERE movie_id=" + movieId;
        return em.createQuery(jpql, Movie.class).getSingleResult();
    }

    public List<Movie> findByDirectorOrActorOrOpeningDate(MovieSearchDTO param,
                                                          BooleanExpression director,
                                                          BooleanExpression actor,
                                                          BooleanExpression openingDate) {
        JPAQueryFactory query = new JPAQueryFactory(em);
        QMovie qMovie = QMovie.movie;
        QMovieWorker qMovieWorker = QMovieWorker.movieWorker;

        List<Movie> movies = query.select(qMovie)
                .distinct()
                .from(qMovie, qMovieWorker)
                .join(qMovie.movieWorkers, qMovieWorker).fetchJoin()
                .where(director, actor, openingDate)
                .fetch();

        return movies;
    }

    public List<Movie> findAll() {
        JPAQueryFactory query = new JPAQueryFactory(em);
        QMovie qMovie = QMovie.movie;
        QMovieWorker qMovieWorker = QMovieWorker.movieWorker;

        List<Movie> results = (List<Movie>) query.from(qMovie, qMovieWorker)
                .leftJoin(qMovie.movieWorkers, qMovieWorker)
                .where(qMovie.id.eq(qMovieWorker.movie.id), qMovieWorker.isNotNull())
                .offset(0).limit(2)
                .fetchResults()
                .getResults();

        return results;
    }
}
