package kr.co.mash_up.repository;

import kr.co.mash_up.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(String userId);

    User findByUserIdAndPassword(String userId, String password);

    List<User> findByGender(Integer gender);
}
