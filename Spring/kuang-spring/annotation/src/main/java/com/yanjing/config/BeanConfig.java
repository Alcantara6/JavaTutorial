package com.yanjing.config;

import com.yanjing.pojo.House;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author yanjing
 * @date 2021/8/7
 */
@Configuration
@ComponentScan("com.yanjing")
@Import(BeanConfig2.class)
public class BeanConfig {

    // 注册一个bean，就相当于之前些的一个<bean>标签
    // 返回：bean的类型
    // 方法名： 是bean的id
    @Bean
    public House bigHouse() {

        return new House("yuanda");
    }
}
