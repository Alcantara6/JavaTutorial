package com.yanjing.controller;

import com.yanjing.mapper.UserMapper;
import com.yanjing.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yanjing
 * @date 2021/10/27
 * 整合Mybatis
 */
@RestController
public class MybatisUserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUsers")
    public List<User> queryStudents() {

        return userMapper.queryUserList();
    }

    @GetMapping("/queryStudentById/{id}")
    public User queryStudentById(@PathVariable Integer id) {

        return userMapper.queryUserById(id);
    }
}
