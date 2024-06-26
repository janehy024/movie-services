package movie.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QScreen is a Querydsl query type for Screen
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QScreen extends EntityPathBase<Screen> {

    private static final long serialVersionUID = -2026013000L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QScreen screen = new QScreen("screen");

    public final TimePath<java.time.LocalTime> endTime = createTime("endTime", java.time.LocalTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMovie movie;

    public final TimePath<java.time.LocalTime> startTime = createTime("startTime", java.time.LocalTime.class);

    public final QTheater theater;

    public QScreen(String variable) {
        this(Screen.class, forVariable(variable), INITS);
    }

    public QScreen(Path<? extends Screen> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QScreen(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QScreen(PathMetadata metadata, PathInits inits) {
        this(Screen.class, metadata, inits);
    }

    public QScreen(Class<? extends Screen> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.movie = inits.isInitialized("movie") ? new QMovie(forProperty("movie")) : null;
        this.theater = inits.isInitialized("theater") ? new QTheater(forProperty("theater")) : null;
    }

}

