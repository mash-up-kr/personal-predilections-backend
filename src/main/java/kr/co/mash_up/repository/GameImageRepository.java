package kr.co.mash_up.repository;


import kr.co.mash_up.domain.GameImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameImageRepository extends JpaRepository<GameImage, Long> {

    GameImage findByFileName(String fileName);

}
