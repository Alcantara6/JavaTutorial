package com.yanjing.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yanjing
 * @date 2021/10/19
 */
@Component
public class Cat {

    // Spring的方式，Value注解赋值
    @Value("阿喵")
    private String name;

    // Spring SPEL表达式取出配置文件的值
    @Value("${weight}")
    // @Value("${4*9}")
    private Integer weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + weight +
                '}';
    }
}
