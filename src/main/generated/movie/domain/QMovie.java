package movie.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMovie is a Querydsl query type for Movie
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMovie extends EntityPathBase<Movie> {

    private static final long serialVersionUID = -486176924L;

    public static final QMovie movie = new QMovie("movie");

    public final EnumPath<Genre> genre = createEnum("genre", Genre.class);

    public final StringPath id = createString("id");

    public final ListPath<MovieWorker, QMovieWorker> movieWorkers = this.<MovieWorker, QMovieWorker>createList("movieWorkers", MovieWorker.class, QMovieWorker.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final DatePath<java.util.Date> openingDate = createDate("openingDate", java.util.Date.class);

    public final NumberPath<Integer> runningTime = createNumber("runningTime", Integer.class);

    public final ListPath<Screen, QScreen> screens = this.<Screen, QScreen>createList("screens", Screen.class, QScreen.class, PathInits.DIRECT2);

    public QMovie(String variable) {
        super(Movie.class, forVariable(variable));
    }

    public QMovie(Path<? extends Movie> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMovie(PathMetadata metadata) {
        super(Movie.class, metadata);
    }

}

