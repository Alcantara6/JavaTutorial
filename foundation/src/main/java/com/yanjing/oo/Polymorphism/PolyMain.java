package com.yanjing.oo.Polymorphism;

/**
 * @author yanjing
 * @date 2023/3/5
 */
public class PolyMain {

    public static void main(String[] args) {
        PolyMain poly = new PolyMain();
        // 引用类型可以是实际对象类型的子类
        Animal dog = new Dog();
        poly.givenShot(dog);
    }

    // 参数和返回类型也可以多态
    public void givenShot(Animal a) {
        a.makeNoise();
    }
}
