package com.yanjing.oo.ModifierAuth.animal;

/**
 * @author yanjing
 * @date 2023/6/4
 */
public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    protected String getName() {
        return name;
    }
}
