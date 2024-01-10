package movie.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMovieWorker is a Querydsl query type for MovieWorker
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMovieWorker extends EntityPathBase<MovieWorker> {

    private static final long serialVersionUID = 2033888258L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMovieWorker movieWorker = new QMovieWorker("movieWorker");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMovie movie;

    public final QWorker workers;

    public QMovieWorker(String variable) {
        this(MovieWorker.class, forVariable(variable), INITS);
    }

    public QMovieWorker(Path<? extends MovieWorker> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMovieWorker(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMovieWorker(PathMetadata metadata, PathInits inits) {
        this(MovieWorker.class, metadata, inits);
    }

    public QMovieWorker(Class<? extends MovieWorker> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.movie = inits.isInitialized("movie") ? new QMovie(forProperty("movie")) : null;
        this.workers = inits.isInitialized("workers") ? new QWorker(forProperty("workers")) : null;
    }

}

