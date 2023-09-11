package com.yanjing.oo;

/**
 * @author yanjing
 * @date 2023/3/12
 */
public class SubWithConstructor extends SuperWithConstructor {

    private boolean c;

    public SubWithConstructor() {
    }

    public SubWithConstructor(String a, boolean c) {
        super(a);
        c = c;
    }

    private SubWithConstructor(Integer b, boolean c) {
        super(b);
        c = c;
    }

    public SubWithConstructor(String a, Integer b, boolean c) {
        super(a, b);
        c = c;
    }

    public SubWithConstructor(boolean c) {
        c = c;
    }

    /**
     * 从某个构造函数调用重载版的另一个构造函数
     * @param a
     * @param b
     */
    public SubWithConstructor(String a, Integer b) {
        this(a, b, true);
    }

    /**
     * call private constructor inner class
     */
    public static SubWithConstructor factoryConstruct(Integer b, boolean c) {
        return new SubWithConstructor(b, c);
    }
}
