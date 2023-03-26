package com.yanjing.oo;

/**
 * @author yanjing
 * @date 2023/3/19
 */
public class TestStatic {

    static final int x = 1;

    static int a() {
        return x + 1;
    }

    int b() {
        int aResult = a();
        return aResult + 2;
    }
}
