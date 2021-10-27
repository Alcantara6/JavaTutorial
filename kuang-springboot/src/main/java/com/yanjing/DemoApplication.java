package com.yanjing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication: 标注这个类是SpringBoot的一个应用，启动类下的所有资源被导入
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        // 将SpringBoot应用启动
        // SpringApplication类
        // run方法
        SpringApplication.run(DemoApplication.class, args);
    }
}
