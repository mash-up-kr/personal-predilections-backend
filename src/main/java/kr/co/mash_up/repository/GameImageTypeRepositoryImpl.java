package kr.co.mash_up.repository;

import com.mysema.query.jpa.impl.JPAQuery;
import kr.co.mash_up.domain.GameImageType;
import kr.co.mash_up.domain.QGameImageType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public class GameImageTypeRepositoryImpl implements GameImageTypeRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<GameImageType> findAllOrderByIdASC() {
        JPAQuery query = new JPAQuery(entityManager);
        QGameImageType qGameImageType = QGameImageType.gameImageType;

        query.from(qGameImageType)
                .orderBy(qGameImageType.id.asc());

        return query.list(qGameImageType);
    }
}
