package com.yanjing.controller;

import com.yanjing.dto.response.Response;
import com.yanjing.dto.response.ResponseUtils;
import com.yanjing.dto.user.UserVo;
import com.yanjing.exception.BizException;
import com.yanjing.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanjing
 * @date 2021/11/7
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("/register")
    public Response<UserVo> register(@RequestBody UserVo userVo) {

        try {
            userService.register(userVo);
        } catch (BizException e) {
            return ResponseUtils.internalServerError(e.getMessage());
        }
        return ResponseUtils.success(userVo);
    }

    @CrossOrigin
    @PostMapping("/login")
    public Response<UserVo> login(@RequestBody UserVo userVo) {

        try {
            userService.login(userVo);
            return ResponseUtils.success(userVo);
        } catch (BizException e) {
            return ResponseUtils.internalServerError(e.getMessage());
        }
    }

    @CrossOrigin
    @PostMapping("/login/v2")
    public Response<UserVo> loginByShiro(@RequestBody UserVo userVo) {

        UsernamePasswordToken token = new UsernamePasswordToken(userVo.getUsername(), userVo.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return ResponseUtils.success(userVo);
        } catch (AuthenticationException e) {
            return ResponseUtils.internalServerError(e.getMessage());
        }
    }
}
