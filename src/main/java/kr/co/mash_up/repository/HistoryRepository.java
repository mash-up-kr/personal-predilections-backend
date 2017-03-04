package kr.co.mash_up.repository;

import kr.co.mash_up.domain.Game;
import kr.co.mash_up.domain.History;
import kr.co.mash_up.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HistoryRepository extends JpaRepository<History, Long> {

    History findByUserAndGame(User user, Game game);

}
