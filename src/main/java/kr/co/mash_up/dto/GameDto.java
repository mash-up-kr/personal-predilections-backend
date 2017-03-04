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
public class GameDto {

    @JsonProperty("id")
    private Long id;

    public static class Builder {
        private Long id;

        public GameDto build() {
            GameDto gameDto = new GameDto();
            gameDto.setId(id);
            return gameDto;
        }

        public GameDto.Builder withId(Long id) {
            this.id = id;
            return this;
        }
    }
}






