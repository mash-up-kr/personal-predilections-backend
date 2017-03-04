package kr.co.mash_up.service;


import kr.co.mash_up.domain.*;
import kr.co.mash_up.dto.GameDto;
import kr.co.mash_up.dto.GameImageDto;
import kr.co.mash_up.dto.GameResultDto;
import kr.co.mash_up.dto.UserDto;
import kr.co.mash_up.repository.GameImageTypeRepository;
import kr.co.mash_up.repository.GameRepository;
import kr.co.mash_up.repository.HistoryRepository;
import kr.co.mash_up.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service(value = "gameService")
@Slf4j
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameImageTypeRepository gameImageTypeRepository;

    @Transactional
    public GameDto create(String userId) {

        // user id로 게임 생성
        Game game = new Game();
        Game savedGame = gameRepository.save(game);

        log.info(userId);

        // 히스토리에 주최자로 등록
        User promoter = userRepository.findByUserId(userId);
        historyRepository.save(new History(promoter, savedGame, true));

        // 자신을 제외한 유저들 랜덤 선택하여 히스토리에 저장
        long userCount = userRepository.count();

        generatorRandomUserId(userCount, 12).forEach(aLong -> {
            User findUser = userRepository.findOne(aLong);
            historyRepository.save(new History(findUser, savedGame, false));
        });

        return new GameDto.Builder()
                .withId(savedGame.getId())
                .build();
    }


    private Set<Long> generatorRandomUserId(long userCount, int size) {
        final Set<Long> randomUserId = new HashSet<>();
        while (randomUserId.size() < size) {
            randomUserId.add(ThreadLocalRandom.current().nextLong(userCount) + 1);
        }
        return randomUserId;
    }

    @Transactional(readOnly = true)
    public List<GameImageDto> getGameStageInfo(Long gameId, String gameStage) {
        Game findGame = gameRepository.findOne(gameId);

        List<GameImageDto> gameImageDtos = new ArrayList<>();

        findGame.getHistories().forEach(history -> {
            GameImageType gameImageType = gameImageTypeRepository.findByName(gameStage);

            history.getUser().getGameImages().stream()
                    .filter(gameImage -> gameImage.getGameImageType() == gameImageType)
                    .forEach(gameImage -> {
                        gameImageDtos.add(new GameImageDto.Builder()
                                .withUrl(gameImage.getImageUrl())
                                .withType(gameStage)
                                .build());
                    });
        });

        return gameImageDtos;
    }

    /*
     game_result:{
         matching_ratio: "Double"
         user:{
            name: "String",
            gender: Int,
            phone_number: "String",
            image:{
               url: "String"
            }
         }
      }
     */
    @Transactional(readOnly = true)
    public GameResultDto result(Long gameId, List<GameImage> gameImages) {
        Game findGame = gameRepository.findOne(gameId);

        // 히스토리에 가중치를 계산한다.
        gameImages.forEach(gameImage -> {
            User findUser = gameImage.getUser();
            Long weight = gameImage.getGameImageType().getWeight();

            History findHistory = historyRepository.findByUserAndGame(findUser, findGame);
            findHistory.addWeight(weight);
        });


        User topMatchingRationUser = null;
        Double topMatchingRatio = 0d;
        for (History history : findGame.getHistories()) {
            if (history.getMatchingRatio() > topMatchingRatio) {
                topMatchingRatio = history.getMatchingRatio();
                topMatchingRationUser = history.getUser();
            }
        }

        GameImageType gameImageType = gameImageTypeRepository.findByName("FACE");

        Optional<GameImage> findGameImage = topMatchingRationUser.getGameImages().stream()
                .filter(gameImage -> gameImage.getGameImageType() == gameImageType)
                .findFirst();

        GameImage gameImage = findGameImage.get();

        GameImageDto gameImageDto = new GameImageDto.Builder()
                .withType(gameImageType.getName())
                .withUrl(gameImage.getImageUrl())
                .build();

        UserDto userDto = new UserDto.Builder()
                .withName(topMatchingRationUser.getName())
                .withPhoneNumber(topMatchingRationUser.getPhoneNumber())
                .withGender(topMatchingRationUser.getGender())
                .withGameImageDto(gameImageDto)
                .build();

        return new GameResultDto.Builder()
                .withMatchingRatio(topMatchingRatio * 100)
                .withUserDto(userDto)
                .build();
    }
}
