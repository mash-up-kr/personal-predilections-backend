package kr.co.mash_up.controller;

import kr.co.mash_up.domain.User;
import kr.co.mash_up.service.UserService;
import kr.co.mash_up.util.ParameterUtil;
import kr.co.mash_up.vo.ResponseVO;
import kr.co.mash_up.vo.UserLoginRequestVO;
import kr.co.mash_up.vo.UserRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /*
    /user - POST - 회원가입
   request
   {
      user: {
         id: "String",
         pw: "String",
         name: "String",
         gender: Int,
         phone_number: "String",
         images: [
            {
               url:"String",
               type: "String"
            },
            ....
         ]
      }
   }

   response
   status code: 201 Created
   {
      // empty
   }
     */
    @PostMapping(value = "")
    public ResponseVO create(@RequestBody UserRequestVO requestVO) {
        if (ParameterUtil.checkParameterEmpty(requestVO.getUserId(), requestVO.getPassword(), requestVO.getName(),
                requestVO.getGender(), requestVO.getPhoneNumber())) {
            return ResponseVO.badRequest();
        }

        User user = userService.create(requestVO);

        if (user == null) {
            return ResponseVO.badRequest();
        }
        return ResponseVO.ok();
    }

    /*
    /user/match/id - GET - id 중복검사
   request
   id= "String"

   response
   status code : 2xx , 4xx
     */
    @GetMapping(value = "/match/id/{user_id}")
    public ResponseVO matchId(@PathVariable("user_id") String userId) {
        log.error(userId);
        if (ParameterUtil.checkParameterEmpty(userId)) {
            return ResponseVO.badRequest();
        }

        User user = userService.validationUserId(userId);

        if (user == null) {
            return ResponseVO.badRequest();
        }
        return ResponseVO.ok();
    }

    /*
    /user/login - POST - 로그인(token 생성)
   request
   {
      id: "String",
      pw: "String"
   }

   response
   status code: 200 Success
   {
      // empty
   }
     */
    @PostMapping(value = "/login")
    public ResponseVO login(@RequestBody UserLoginRequestVO requestVO) {
        if (ParameterUtil.checkParameterEmpty(requestVO.getUserId(), requestVO.getPassword())) {
            return ResponseVO.badRequest();
        }

        User user = userService.login(requestVO.getUserId(), requestVO.getPassword());
        if (user == null) {
            return ResponseVO.badRequest();
        }
        return ResponseVO.ok();
    }
}
