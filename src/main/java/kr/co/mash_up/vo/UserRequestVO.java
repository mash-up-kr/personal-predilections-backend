package kr.co.mash_up.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import kr.co.mash_up.domain.User;
import kr.co.mash_up.dto.GameImageDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserRequestVO extends RequestVO {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("password")
    private String password;

    @JsonProperty("name")
    private String name;

    @JsonProperty("gender")
    private Boolean gender;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("images")
    private List<GameImageDto> gameImageDtos;

    public User toUserEntity() {
        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);
        user.setName(name);

        if (gender) {
            user.setGender(User.Gender.MALE);
        } else {
            user.setGender(User.Gender.FEMALE);
        }
        user.setPhoneNumber(phoneNumber);
        return user;
    }


}
