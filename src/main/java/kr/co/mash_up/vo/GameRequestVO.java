package kr.co.mash_up.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import kr.co.mash_up.dto.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class GameRequestVO extends RequestVO {

    @JsonProperty("user")
    private UserDto userDto;

}
