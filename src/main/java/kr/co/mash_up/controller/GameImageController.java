package kr.co.mash_up.controller;


import kr.co.mash_up.dto.GameImageDto;
import kr.co.mash_up.service.GameImageService;
import kr.co.mash_up.util.ParameterUtil;
import kr.co.mash_up.vo.DataListResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/api/game_images")
@Slf4j
public class GameImageController {

    @Autowired
    GameImageService gameImageService;

    @PostMapping(value = "")
    public DataListResponseVO create(@RequestParam(name = "files") List<MultipartFile> files) {
        log.error(files.toString());
        if (ParameterUtil.checkParameterEmpty(files)) {
            return DataListResponseVO.badRequest();
        }

        List<GameImageDto> gameImageDtos = gameImageService.create(files);

        if (gameImageDtos == null) {
            return DataListResponseVO.badRequest();
        }

        return new DataListResponseVO<GameImageDto>(gameImageDtos);
    }


}
