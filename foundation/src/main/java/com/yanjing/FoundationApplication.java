package com.yanjing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author yanjing
 * @date 2022/3/7
 */
@SpringBootApplication
@EnableScheduling
public class FoundationApplication {

    public static void main(String[] args) {

        SpringApplication.run(FoundationApplication.class, args);
    }
}
