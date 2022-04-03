package com.yanjing.stream;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

/**
 * @author yanjing
 * @date 2022/3/27
 */
public class Functional {

    @Test
    public void retFunction() {

        new StreamApi().of();

        Function<String, Integer> s = Integer::parseInt;
        System.out.println(s.apply("123"));
    }

    /**
     * 只要是在某个函数式接口中声明了这样的方法：两个参数，参数类型是 int或者泛型，并且返回值是 int或者泛型的，都可以完美接收。
     * 与接口的名称关系倒是不大
     */
    @Test
    public void retComparator() {

        Comparator<Integer> comparator = Integer::compare;
        System.out.println(comparator.compare(100, 10));

        IntBinaryOperator operator = Integer::compare;
        System.out.println(operator.applyAsInt(10, 100));

        IntBinaryOperator lambda = (int x, int y) -> (x < y) ? -1 : ((x == y) ? 0 : 1);
        System.out.println(lambda.applyAsInt(100, 100));
    }
}
