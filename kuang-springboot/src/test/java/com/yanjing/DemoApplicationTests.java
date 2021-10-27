package com.yanjing;

import com.yanjing.pojo.Cat;
import com.yanjing.pojo.Dog;
import com.yanjing.pojo.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private Dog dog;
    @Autowired
    private Person person;
    @Autowired
    private Cat cat;

    @Test
    void contextLoads() {

        System.out.println(dog);
        System.out.println(person);
        System.out.println(cat);
    }

    @DisplayName("最简单测试")
    @Test
    void testSimpleAssertions() {
        Assertions.assertEquals(5, 3 + 2, "失败了！");
    }
}
