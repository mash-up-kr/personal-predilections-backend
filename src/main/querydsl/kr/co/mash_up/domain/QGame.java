package kr.co.mash_up.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QGame is a Querydsl query type for Game
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QGame extends EntityPathBase<Game> {

    private static final long serialVersionUID = 650463268L;

    public static final QGame game = new QGame("game");

    public final ListPath<History, QHistory> histories = this.<History, QHistory>createList("histories", History.class, QHistory.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QGame(String variable) {
        super(Game.class, forVariable(variable));
    }

    public QGame(Path<? extends Game> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGame(PathMetadata<?> metadata) {
        super(Game.class, metadata);
    }

}

