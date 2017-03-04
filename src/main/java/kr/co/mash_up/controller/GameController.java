package kr.co.mash_up.controller;

import kr.co.mash_up.dto.GameDto;
import kr.co.mash_up.dto.GameImageDto;
import kr.co.mash_up.dto.GameResultDto;
import kr.co.mash_up.service.GameService;
import kr.co.mash_up.vo.DataListResponseVO;
import kr.co.mash_up.vo.DataResponseVO;
import kr.co.mash_up.vo.GameRequestVO;
import kr.co.mash_up.vo.GameResultRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/games")
public class GameController {

    @Autowired
    private GameService gameService;

    /*
    /games - POST - 게임시작
   request
   {
      user: {
         id: Int,
      }
   }

   response
   {
      game:{
         id: Int
      }
   }
     */
    @PostMapping(value = "")
    public DataResponseVO create(@RequestBody GameRequestVO requestVO) {
        GameDto gameDto = gameService.create(requestVO.getUserDto().getUserId());

        if (gameDto == null) {
            DataResponseVO.badRequest();
        }

        return new DataResponseVO<GameDto>(gameDto);
    }

    /*
    /games - GET - 게임 정보 요청
   request
   game_id= Int
   game_stage = "String"

   response
   {
      images: [
         {
            id: Int,
            url: "String"
         },
         ...
      ]
   }
     */
    @GetMapping("/{game_id}/{game_stage}")
    public DataListResponseVO get(@PathVariable("game_id") Long gameId,
                                  @PathVariable("game_stage") String gameStage) {

        List<GameImageDto> gameImageDtos = gameService.getGameStageInfo(gameId, gameStage);

        if (gameImageDtos == null) {
            return DataListResponseVO.badRequest();
        }

        return new DataListResponseVO<GameImageDto>(gameImageDtos);
    }

    /*
/game/result - POST - 게임 결과
   request
   {
      game:{
        id: Int
      },
      images[
         {
            id: Int
         },
         ...
      ]
   }

   response
   {
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
   }
 */
    @PostMapping("/results")
    public DataResponseVO result(@RequestBody GameResultRequestVO requestVO) {

        GameResultDto gameResultDto = gameService.result(requestVO.getGameDto().getId(), requestVO.getGameImages());

        if (gameResultDto == null) {
            return DataResponseVO.badRequest();
        }

        return new DataResponseVO<GameResultDto>(gameResultDto);
    }

}
