package com.yanjing.controller;

import com.yanjing.dto.Result;
import com.yanjing.entity.User;
import com.yanjing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

/**
 * @author yanjing
 * @date 2021/11/7
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("/login")
    public Result login(@RequestBody User requestUser) {

        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getPassword());

        if (user == null) {

            return new Result(400);
        } else {

            return new Result(200);
        }
    }
}
