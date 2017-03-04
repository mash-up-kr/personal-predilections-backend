package kr.co.mash_up.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QGameImage is a Querydsl query type for GameImage
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QGameImage extends EntityPathBase<GameImage> {

    private static final long serialVersionUID = 1793976215L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGameImage gameImage = new QGameImage("gameImage");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath fileName = createString("fileName");

    public final QGameImageType gameImageType;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath originalFileName = createString("originalFileName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath url = createString("url");

    public final QUser user;

    public QGameImage(String variable) {
        this(GameImage.class, forVariable(variable), INITS);
    }

    public QGameImage(Path<? extends GameImage> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QGameImage(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QGameImage(PathMetadata<?> metadata, PathInits inits) {
        this(GameImage.class, metadata, inits);
    }

    public QGameImage(Class<? extends GameImage> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.gameImageType = inits.isInitialized("gameImageType") ? new QGameImageType(forProperty("gameImageType")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

