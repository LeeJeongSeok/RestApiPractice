package com.stevelee.restapipractice.controller;

import com.stevelee.restapipractice.dto.User;
import com.stevelee.restapipractice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "회원 API")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "로그인", notes = "로그인 프로세스를 처리한다.")
    public String login(@RequestBody String userId, @RequestBody String userPassword) {
        String result = userService.login(userId, userPassword);
        return result;
    }

    @PostMapping("/join")
    @ApiOperation(value = "회원가입", notes = "회원가입 프로세스를 처리한다.")
    public String join(@RequestBody User user) {

        userService.join(user);
        return "ok";
    }

    @PostMapping("/findUserById")
    @ApiOperation(value = "회원조회", notes = "회원가입된 아이디를 기준으로 회원을 조회하는 프로세스를 실행한다.")
    public User findUserById(@RequestBody String userId) {
        return userService.findUserById(userId);
    }

    @PostMapping("/findAll")
    @ApiOperation(value = "전체 회원조회", notes = "현재 DB에 저장된 전체 회원을 조회하는 프로세스를 실행한다.")
    public List<User> findAll() {
        return userService.findAll();
    }
}
