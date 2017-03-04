package kr.co.mash_up.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Setter
@Getter
@ToString
public class GameImageRequestVO {

    @JsonProperty
    private String url;

    @JsonProperty
    private String type;
}
