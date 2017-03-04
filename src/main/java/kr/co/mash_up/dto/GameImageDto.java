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
public class GameImageDto {

    @JsonProperty
    private String url;

    @JsonProperty
    private String type;

    public static class Builder {
        private String url;
        private String type;

        public GameImageDto build() {
            GameImageDto gameImageDto = new GameImageDto();
            gameImageDto.setUrl(url);
            gameImageDto.setType(type);
            return gameImageDto;
        }

        public Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
        }
    }
}
