package kr.co.mash_up.service;


import kr.co.mash_up.domain.GameImage;
import kr.co.mash_up.domain.User;
import kr.co.mash_up.repository.GameImageRepository;
import kr.co.mash_up.repository.UserRepository;
import kr.co.mash_up.util.FileUtil;
import kr.co.mash_up.vo.UserRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameImageRepository gameImageRepository;

    public User validationUserId(String userId) {
        User findUser = userRepository.findByUserId(userId);

        return findUser;
    }

    public User login(String userId, String password) {
        User findUser = userRepository.findByUserIdAndPassword(userId, password);

        return findUser;
    }

    public User create(UserRequestVO requestVO) {
        User savedUser = userRepository.save(requestVO.toUserEntity());

        requestVO.getGameImageDtos().forEach(gameImageDto -> {
            GameImage gameImage = gameImageRepository.findByFileName(GameImage.getFileNameFromUrl(gameImageDto.getUrl()));

            gameImage.setUser(savedUser);
            FileUtil.moveFile(GameImage.getImageUploadTempPath() + "/" + gameImage.getFileName(),
                    gameImage.getImageUploadPath());
        });

        return savedUser;
    }
}
