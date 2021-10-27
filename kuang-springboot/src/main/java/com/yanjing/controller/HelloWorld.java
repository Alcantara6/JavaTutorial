package com.yanjing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    // 接口: http://localhost:8080/hello
    @RequestMapping("helloWorld")
    public String helloWorld() {
        return "hello world";
    }
}