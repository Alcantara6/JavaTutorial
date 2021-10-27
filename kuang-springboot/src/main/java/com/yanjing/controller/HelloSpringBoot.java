package com.yanjing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 自动装配：原理！
@Controller
@RequestMapping("hello")
public class HelloSpringBoot {

    // 接口: http://localhost:8080/hello/hello
    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
