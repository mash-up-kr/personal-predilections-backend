package kr.co.mash_up.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GameResultDto {

    @JsonProperty("matching_ratio")
    private Double matchingRatio;

    @JsonProperty("user")
    private UserDto userDto;

    public static class Builder {
        private Double matchingRatio;
        private UserDto userDto;

        public GameResultDto build() {
            GameResultDto gameResultDto = new GameResultDto();
            gameResultDto.setMatchingRatio(matchingRatio);
            gameResultDto.setUserDto(userDto);
            return gameResultDto;
        }

        public GameResultDto.Builder withMatchingRatio(Double matchingRatio) {
            this.matchingRatio = matchingRatio;
            return this;
        }

        public GameResultDto.Builder withUserDto(UserDto userDto) {
            this.userDto = userDto;
            return this;
        }
    }
}
