package kr.co.mash_up.repository;


import kr.co.mash_up.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
