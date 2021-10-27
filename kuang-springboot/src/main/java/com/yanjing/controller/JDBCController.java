package com.yanjing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author yanjing
 * @date 2021/10/26
 */
@RestController
public class JDBCController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 查询数据库的所有信息
    // 没有实体类，数据库中的东西怎么获取？ Map
    @GetMapping("/userList")
    public List<Map<String, Object>> userList() {

        String sql = "select * from user";
        return jdbcTemplate.queryForList(sql);
    }

    @GetMapping("/addUser")
    public String addUser() {

        String sql = "insert into springboot.user(id, name, pwd) values (2, '小红', '123456')";
        // 自动提交了事务
        jdbcTemplate.update(sql);
        return "add-ok";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable int id) {

        String sql = "update springboot.user set name = ?, pwd = ? where id = " + id;
        Object[] objects = new Object[2];
        objects[0] = "小花";
        objects[1] = "zzz";
        jdbcTemplate.update(sql, objects);
        return "update-ok";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {

        String sql = "delete from springboot.user where id = ?";
        jdbcTemplate.update(sql, id);
        return "delete-ok";
    }
}
