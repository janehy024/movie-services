package movie.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QActor is a Querydsl query type for Actor
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QActor extends EntityPathBase<Actor> {

    private static final long serialVersionUID = -497618391L;

    public static final QActor actor = new QActor("actor");

    public final QWorker _super = new QWorker(this);

    //inherited
    public final DatePath<java.util.Date> birth = _super.birth;

    //inherited
    public final StringPath filo = _super.filo;

    public final NumberPath<Integer> height = createNumber("height", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath instagram = createString("instagram");

    //inherited
    public final ListPath<MovieWorker, QMovieWorker> movieWorkers = _super.movieWorkers;

    //inherited
    public final StringPath name = _super.name;

    public QActor(String variable) {
        super(Actor.class, forVariable(variable));
    }

    public QActor(Path<? extends Actor> path) {
        super(path.getType(), path.getMetadata());
    }

    public QActor(PathMetadata metadata) {
        super(Actor.class, metadata);
    }

}

