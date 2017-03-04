package kr.co.mash_up.service;

import kr.co.mash_up.domain.GameImage;
import kr.co.mash_up.domain.GameImageType;
import kr.co.mash_up.dto.GameImageDto;
import kr.co.mash_up.repository.GameImageRepository;
import kr.co.mash_up.repository.GameImageTypeRepository;
import kr.co.mash_up.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service(value = "gameImageService")
@Slf4j
public class GameImageService {

    @Autowired
    private GameImageRepository gameImageRepository;

    @Autowired
    private GameImageTypeRepository gameImageTypeRepository;

    public List<GameImageDto> create(List<MultipartFile> files) {

        List<GameImageType> gameImageTypes = gameImageTypeRepository.findAllOrderByIdASC();
        Iterator<GameImageType> iterator = gameImageTypes.iterator();

        List<GameImageDto> gameImageDtos = files.stream()
                .filter(multipartFile -> multipartFile != null && !multipartFile.isEmpty())
                .map(multipartFile -> {
                    GameImage gameImage = new GameImage();

                    String saveName = FileUtil.generateFileName(multipartFile.getOriginalFilename());

                    gameImage.setFileName(saveName);
                    gameImage.setOriginalFileName(multipartFile.getOriginalFilename());
                    gameImage.setGameImageType(iterator.next());

                    FileUtil.upload(multipartFile, GameImage.getImageUploadTempPath(), saveName);

                    GameImage savedGameImage = gameImageRepository.save(gameImage);
                    log.debug(savedGameImage.getFileName());

                    return new GameImageDto.Builder()
                            .withUrl(savedGameImage.getTempImageUrl())
                            .withType(savedGameImage.getGameImageType().getName())
                            .build();
                }).collect(Collectors.toList());

        return gameImageDtos;
    }
}
