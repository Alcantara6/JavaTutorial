package com.yanjing.oo;

/**
 * @author yanjing
 * @date 2023/3/12
 */
public abstract class SuperWithConstructor {

    private String a;

    private Integer b;

    public SuperWithConstructor() {
    }

    public SuperWithConstructor(String a) {
        this.a = a;
    }

    public SuperWithConstructor(Integer b) {
        this.b = b;
    }

    public SuperWithConstructor(String a, Integer b) {
        this.a = a;
        this.b = b;
    }
}
