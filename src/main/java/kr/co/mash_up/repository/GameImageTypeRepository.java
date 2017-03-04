package kr.co.mash_up.repository;


import kr.co.mash_up.domain.GameImageType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameImageTypeRepository extends JpaRepository<GameImageType, Long>, GameImageTypeRepositoryCustom {

    List<GameImageType> findAllOrderByIdASC();

    GameImageType findByName(String name);
}
