package kr.co.mash_up.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import kr.co.mash_up.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty
    private String name;

    @JsonProperty
    private boolean gender;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("image")
    private GameImageDto gameImageDto;

    public static class Builder {
        private String userId = "";
        private String name = "";
        private boolean gender = true;
        private String phoneNumber = "";
        private GameImageDto gameImageDto;

        public UserDto build() {
            UserDto userDto = new UserDto();
            userDto.setUserId(userId);
            userDto.setName(name);
            userDto.setGender(gender);
            userDto.setPhoneNumber(phoneNumber);
            userDto.setGameImageDto(gameImageDto);
            return userDto;
        }

        public Builder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withGender(User.Gender gender) {
            if(gender == User.Gender.MALE){
                this.gender = true;
            }else{
                this.gender = false;
            }
            return this;
        }

        public Builder withPhoneNumber(String phoneNumber) {
            this.name = name;
            return this;
        }

        public Builder withGameImageDto(GameImageDto gameImageDto) {
            this.gameImageDto = gameImageDto;
            return this;
        }
    }
}
