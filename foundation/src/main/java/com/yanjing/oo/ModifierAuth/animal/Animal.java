package com.yanjing.oo.ModifierAuth.animal;

/**
 * @author yanjing
 * @date 2023/6/4
 */
public class Animal {

    private String category;

    public Animal(String category) {
        this.category = category;
    }

    protected String getCategory() {
        return category;
    }
}
