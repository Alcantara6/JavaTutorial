package com.yanjing.oo.ModifierAuth.animal;


/**
 * @author yanjing
 * @date 2023/6/4
 */
public class Dog {

    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public void anotherDog(Dog dog, Cat cat) {
        // Dog可以看到同类别的Dog的私有部分
        String anotherDogName = dog.name;
        // 看不到别的类的私有部分
        // String catName = cat.name;
    }

    public void visitDefaultOfAnotherPkg() {
        // Cannot be accessed from outside package
        // Apple apple = new Apple();
    }

    public void visitProctedOfSamePkg() {
        Cat cat = new Cat("C");
        cat.getName();
    }
}
