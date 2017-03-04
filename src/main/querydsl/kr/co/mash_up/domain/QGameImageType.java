package kr.co.mash_up.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QGameImageType is a Querydsl query type for GameImageType
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QGameImageType extends EntityPathBase<GameImageType> {

    private static final long serialVersionUID = -333822095L;

    public static final QGameImageType gameImageType = new QGameImageType("gameImageType");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final ListPath<GameImage, QGameImage> gameImages = this.<GameImage, QGameImage>createList("gameImages", GameImage.class, QGameImage.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final NumberPath<Long> weight = createNumber("weight", Long.class);

    public QGameImageType(String variable) {
        super(GameImageType.class, forVariable(variable));
    }

    public QGameImageType(Path<? extends GameImageType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGameImageType(PathMetadata<?> metadata) {
        super(GameImageType.class, metadata);
    }

}

