package com.yanjing.controller;

import com.yanjing.entity.User;
import com.yanjing.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yanjing
 * @date 2021/11/4
 */
@RestController("userController")
public class UserController {

    @Autowired
    UserService userService;

    /**
     *
     * @param username 账户
     * @return
     */
    @GetMapping("/userList")
    @RequiresPermissions("user:view") // 权限管理.
    public User findUserInfoByUsername(@RequestParam String username) {
        return userService.findByUsername(username);
    }

    /**
     * 简单模拟从数据库添加用户信息成功
     *
     * @return
     */
    @PostMapping("/userAdd")
    @RequiresPermissions("user:add")
    public String addUserInfo() {
        return "addUser success!";
    }

    /**
     * 简单模拟从数据库删除用户成功
     *
     * @return
     */
    @DeleteMapping("/userDelete")
    @RequiresPermissions("user:delete")
    public String deleteUserInfo() {
        return "deleteUserInfo success!";
    }
}
