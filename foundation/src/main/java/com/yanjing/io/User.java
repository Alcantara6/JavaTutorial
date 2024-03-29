package com.yanjing.io;

import java.io.Serializable;

/**
 * @author yanjing
 * @date 2022/1/6
 */
public class User implements Serializable {

    private static final long serialVersionUID = -3340693206126193734L;

    public User() {
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    private int id;

    private String name;

    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age;
    }
}
