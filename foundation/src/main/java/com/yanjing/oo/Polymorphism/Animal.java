package com.yanjing.oo.Polymorphism;

/**
 * @author yanjing
 * @date 2023/3/5
 */
public class Animal {

    public void makeNoise() {
        System.out.println(this.getClass().getSimpleName() + "make noise");
    }
}
