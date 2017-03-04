package kr.co.mash_up.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QHistory is a Querydsl query type for History
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QHistory extends EntityPathBase<History> {

    private static final long serialVersionUID = 181412642L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHistory history = new QHistory("history");

    public final QGame game;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> matchingRatio = createNumber("matchingRatio", Double.class);

    public final BooleanPath promoter = createBoolean("promoter");

    public final QUser user;

    public final NumberPath<Long> weightSum = createNumber("weightSum", Long.class);

    public QHistory(String variable) {
        this(History.class, forVariable(variable), INITS);
    }

    public QHistory(Path<? extends History> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QHistory(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QHistory(PathMetadata<?> metadata, PathInits inits) {
        this(History.class, metadata, inits);
    }

    public QHistory(Class<? extends History> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.game = inits.isInitialized("game") ? new QGame(forProperty("game")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

