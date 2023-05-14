package com.yanjing.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanjing
 * @date 2023/5/7
 */
public class WildExtends {

    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();

        // 可编译可运行
        List<Animal> animals = new ArrayList<>();
        animals.add(dog1);
        animals.add(dog2);
        takeAnimals(animals);
        // 编译错误
        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        takeAnimals(dogs);
        // 数组，运行期错误
        Dog[] dogArrs = {dog1, dog2};
        takeAnimalsArr(dogArrs);
    }

    public static void takeAnimals(List<Animal> animals) {
        for (Animal animal : animals) {
            // 没问题
        }
        animals.add(new Cat());
    }

    public static void takeAnimalsArr(Animal[] animals) {
        for (Animal animal : animals) {
            // 没问题
        }
        animals[1] = new Cat();
    }

    static abstract class Animal {}

    static class Dog extends Animal {}

    static class Cat extends Animal {}
}
