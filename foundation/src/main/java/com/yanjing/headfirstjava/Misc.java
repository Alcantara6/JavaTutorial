package com.yanjing.headfirstjava;

/**
 * @author yanjing
 * @date 2023/2/18
 */
public class Misc {

    public static void main(String[] args) {


    }

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

    void modifierFinal() {
        Misc m1 = new Misc();
        final Misc m2 = new Misc();
        // m2 = m1; // Cannot assign a value to final variable 'm2'
    }

    void nullPoint() {
        Misc m1 = new Misc();
        m1 = null;  // 上面的对象会被垃圾回收
    }
}
