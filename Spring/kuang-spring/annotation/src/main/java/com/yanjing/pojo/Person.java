package com.yanjing.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.annotation.Resource;

/**
 * @author yanjing
 * @date 2021/8/7
 */
public class Person {

    private Cat cat;

    // （属于J2EE复返，引入javax.annotation-api），默认按照名称进行装配，名称可以通过name属性进行指定。
    @Resource(name = "dog1")
    private Dog dog;

    public Cat getCat() {
        return cat;
    }

    // 在Setter装配
    @Autowired
    @Qualifier("cat1")
    public void setCat(@NonNull Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
