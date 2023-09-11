package com.yanjing.headfirstjava;

import org.junit.jupiter.api.Test;

/**
 * @author yanjing
 * @date 2023/2/18
 */
public class MiscTest {

    @Test
    void javaType() {
        // double转型为int
        int rand = (int) (Math.random() * 100);
        // 必须加上f，否则被Java当做double
        float f = 32.5f;
        // 大的能装小的
        byte b = 123;
        short[] shortArr = new short[3];
        shortArr[0] = b;
    }

    @Test
    void modifierFinal() {
        MiscTest m1 = new MiscTest();
        final MiscTest m2 = new MiscTest();
        // m2 = m1; // Cannot assign a value to final variable 'm2'
    }

    @Test
    void nullPoint() {
        MiscTest m1 = new MiscTest();
        m1 = null;  // 上面的对象会被垃圾回收
    }

    @Test
    public void posOperator() {
        // ~按位非，补码
        int x = 10; // 00001010
        System.out.println(~x); // -11, 11110101，取反后为10，+1后为11

        int y = 10; // 00001010
        int z = 6;  // 00000110
        System.out.println(y & z); // 00000010
        System.out.println(y | z); // 00001110
        System.out.println(y ^ z); // 00001100 位相同时返回0，否则返回1

        int p = -11; // 11110101
        System.out.println(p >> 2);  // 11111101
        System.out.println(p >>> 2); // 00111101
        System.out.println(p << 2);  // 11010100
    }

    @Test
    void immutableTest() {
        // 不变
        int x = 1;
        doMutate(1);
        System.out.println(x);
        // 不变
        String s = "a";
        doMutate(s);
        System.out.println(s);
        // 变了
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        doMutate(sb);
        System.out.println(sb.toString());
    }

    private void doMutate(String s) {
        s = "b";
    }

    private void doMutate(StringBuilder sb) {
        sb.append("b");
    }

    private void doMutate(int x) {
        x = 2;
    }

    void assertTest() {
        int height = -1;
        assert(height > 0) : "height = " + height;
    }
}
