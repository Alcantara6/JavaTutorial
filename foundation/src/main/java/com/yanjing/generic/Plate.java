package com.yanjing.generic;

/**
 * @author yanjing
 * @date 2022/5/25
 * https://www.zhihu.com/question/20400700/answer/117464182
 */
public class Plate<T> {

    static class Food {}

    static class Fruit extends Food {}
    static class Meat extends Food {}

    static class Apple extends Fruit {}
    static class Banana extends Fruit {}
    static class Pork extends Meat {}
    static class Beef extends Meat {}

    static class RedApple extends Apple {}
    static class GreenApple extends Apple {}

    public static void main(String[] args) {
        // 上界，啥水果都能放的盘子
        Plate<? extends Fruit> applePlate = new Plate<Apple>(new Apple());
        // 下界，一个能放水果以及一切是水果基类的盘子
        Plate<? super Fruit> foodPlate = new Plate<Fruit>(new Apple());

        // 无法set,原因是编译器只知道容器内是Fruit或者它的派生类，但具体是什么类型不知道
        // applePlate.setItem(new Fruit());
        Fruit item1 = applePlate.getItem();

        // 元素是Fruit的基类，那往里存粒度比Fruit小的都可以
        foodPlate.setItem(new Fruit());
        foodPlate.setItem(new Apple());

        // 只有所有类的基类Object对象才能装下
        Object item2 = foodPlate.getItem();
    }

    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Plate(T item) {
        this.item = item;
    }
}
