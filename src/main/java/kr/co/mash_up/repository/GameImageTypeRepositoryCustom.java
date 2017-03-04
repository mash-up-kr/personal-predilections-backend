package kr.co.mash_up.repository;


import kr.co.mash_up.domain.GameImageType;

import java.util.List;

public interface GameImageTypeRepositoryCustom {

    List<GameImageType> findAllOrderByIdASC();
}
