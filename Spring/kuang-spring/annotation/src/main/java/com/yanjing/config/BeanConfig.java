package com.yanjing.config;

import com.yanjing.pojo.House;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yanjing
 * @date 2021/8/7
 */
@Configuration
@ComponentScan("com.yanjing")
public class BeanConfig {

    @Bean
    public House bigHouse() {

        return new House("yuanda");
    }
}
