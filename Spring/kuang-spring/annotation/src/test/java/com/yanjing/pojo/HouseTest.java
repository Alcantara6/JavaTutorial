package com.yanjing.pojo;

import com.yanjing.config.BeanConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yanjing
 * @date 2021/8/7
 */
class HouseTest {

    @Test
    public void test1() {

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        House house = context.getBean("bigHouse", House.class);
        assertEquals("yuanda", house.getName());
    }
}