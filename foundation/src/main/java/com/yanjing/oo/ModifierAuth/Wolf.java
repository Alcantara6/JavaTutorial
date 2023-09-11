package com.yanjing.oo.ModifierAuth;

import com.yanjing.oo.ModifierAuth.animal.Animal;

/**
 * @author yanjing
 * @date 2023/6/4
 */
public class Wolf extends Animal {

    public Wolf(String category) {
        super(category);
    }

    // 不同包的子类可override protect方法
    @Override
    protected String getCategory() {
        return super.getCategory();
    }
}
