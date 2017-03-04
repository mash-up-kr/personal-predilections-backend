package kr.co.mash_up.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import kr.co.mash_up.domain.GameImage;
import kr.co.mash_up.dto.GameDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class GameResultRequestVO extends RequestVO {

    @JsonProperty("game")
    GameDto gameDto;

    @JsonProperty("images")
    List<GameImage> gameImages;

}
