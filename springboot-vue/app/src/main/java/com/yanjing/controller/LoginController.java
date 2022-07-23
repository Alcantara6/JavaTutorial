package com.yanjing.controller;

import com.yanjing.vo.response.Response;
import com.yanjing.vo.response.ResponseUtils;
import com.yanjing.vo.user.UserVo;
import com.yanjing.entity.User;
import com.yanjing.exception.BizException;
import com.yanjing.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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
    public Response<UserVo> login(@RequestBody UserVo userVo, HttpSession session) {

        try {
            userService.login(userVo);
            session.setAttribute("user", userVo);
            return ResponseUtils.success(userVo);
        } catch (BizException e) {
            return ResponseUtils.internalServerError(e.getMessage());
        }
    }

    @CrossOrigin
    @PostMapping("/login/v2")
    public Response<UserVo> loginByShiro(@RequestBody UserVo userVo, HttpSession session) {

        UsernamePasswordToken token = new UsernamePasswordToken(userVo.getUsername(), userVo.getPassword());
        token.setRememberMe(true);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            session.setAttribute("user", userVo);
            return ResponseUtils.success(userVo);
        } catch (AuthenticationException e) {
            return ResponseUtils.internalServerError(e.getMessage());
        }
    }

    @CrossOrigin
    @GetMapping("/authentication")
    public Response<UserVo> authentication() {
        Subject subject = SecurityUtils.getSubject();

        boolean authenticated = subject.isAuthenticated();
        boolean remembered = subject.isRemembered();
        System.out.println("API authentication | isAuthenticated: " + subject.isAuthenticated());
        System.out.println("API authentication | isRemembered: " + subject.isRemembered());
        if (authenticated || remembered) {
            String username = (String) subject.getPrincipal();
            User user = userService.getByName(username);
            UserVo userVo = UserVo.fromUserDo(user);
            return ResponseUtils.success(userVo);
        }
        return ResponseUtils.success(null);
    }

    @CrossOrigin
    @PostMapping("/logout")
    public Response<Boolean> logout(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.logout();
            return ResponseUtils.success(true);
        } catch (AuthenticationException e) {
            return ResponseUtils.internalServerError(e.getMessage());
        }
    }
}
