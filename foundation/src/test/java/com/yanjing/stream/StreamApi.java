package com.yanjing.stream;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author yanjing
 * @date 2022/3/27
 */
public class StreamApi {

    @Test
    public void of() {


        Stream<String> stringStream = Stream.of("a", "b", "c");
    }

    @Test
    public void empty() {
        Stream<Object> empty = Stream.empty();
    }

    @Test
    public void concat() {

        Stream<String> a = Stream.of("a", "b", "c");
        Stream<String> b = Stream.of("d", "e");
        Stream<String> c = Stream.concat(a, b);
    }

    @Test
    public void max() {
        Stream<Integer> integerStream = Stream.of(2, 2, 100, 5);
        Optional<Integer> max = integerStream.max(Integer::compareTo);
    }

    @Test
    public void maxCustom() {
        Stream<Integer> integerStream = Stream.of(2, 2, 100, 5);
        Optional<Integer> max = integerStream.max((x, y) -> x < y ? -1 : (x.equals(y) ? 0 : 1));
    }

    @Test
    public void findFirst() {

        Stream<String> stringStream = Stream.of("a", "b", "c", "b");
        Optional<String> first = stringStream.findFirst();
    }


    @Test// 获取 Stream 中的某个元素，如果是串行情况下，一般都会返回第一个元素，并行情况下就不一定了。
    public void findAny() {

        Stream<String> stringStream = Stream.of("a", "b", "c", "b");
        stringStream.findAny();
    }

    @Test
    public void count() {

        Stream<String> stringStream = Stream.of("a", "b", "c", "b");
        stringStream.count();
    }


    @Test// 在这个通道中对 Stream 的每个元素执行对应的操作
    public void peek() {

        Stream<String> stringStream = Stream.of("a", "b", "c");
        List<String> list = stringStream.peek(e -> System.out.println(e.toUpperCase())).collect(Collectors.toList());
    }


    @Test// forEach 执行之后，这个 Stream 就真的被消费掉了，之后这个 Stream 流就没有了，不可以再对它进行后续操作了
    public void forEach() {

        Stream<String> stringStream = Stream.of("a", "b", "c");
        stringStream.forEach(e -> System.out.println(e.toUpperCase()));
    }


    @Test// 并行时，有顺序保证的，也就是对 Stream 中元素按插入时的顺序进行消费
    public void forEachOrdered() {

        Stream<String> stringStream = Stream.of("a", "b", "c");
        stringStream.parallel().forEachOrdered(e -> System.out.println(e.toUpperCase()));
    }

    @Test
    public void limit() {

        Stream<String> stringStream = Stream.of("a", "b", "c");
        stringStream.limit(2).forEach(System.out::println);
    }

    @Test
    public void skip() {

        Stream<String> stringStream = Stream.of("a", "b", "c");
        stringStream.skip(2).forEach(System.out::println);
    }


    @Test
    public void distinct() {

        Stream<String> stringStream = Stream.of("a", "b", "c", "b");
        stringStream.distinct().forEach(System.out::println);
    }


    @Test
    public void sorted() {

        Stream<String> stringStream = Stream.of("a", "c", "b");
        stringStream.sorted().forEach(System.out::println);
    }

    @Test
    public void customSorted() {

        Stream<String> stringStream = Stream.of("a1", "c6", "b3");
        stringStream.sorted(Comparator.comparingInt(x -> Integer.parseInt(x.substring(1))))
                .forEach(System.out::println);
    }

    @Test
    public void filter() {
        Stream<String> stringStream = Stream.of("a", "b", "c");
        stringStream.filter(s -> s.equals("b")).forEach(System.out::println);
    }

    /**
     * 将元素转换成 int 类型，在 map方法的基础上进行封装
     * mapToIntTest, mapToLong, mapToDouble
     */
    @Test
    public void mapToIntTest() {
        Stream<String> stream = Stream.of("1", "2", "3");
        int sum = stream.mapToInt(Integer::parseInt).sum();
        System.out.println(sum);
    }

    @Test
    public void flatMap() {
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<String> list2 = Arrays.asList("d", "e", "f");
        List<List<String>> nestedList = new ArrayList<>();
        nestedList.add(list1);
        nestedList.add(list2);

        // flatMap里面对二级list转为stream
        nestedList.stream().flatMap(Collection::stream).forEach(System.out::println);
    }

    @Test
    public void flatMapToInt() {
        List<String> list1 = Arrays.asList("1", "2", "3");
        List<String> list2 = Arrays.asList("4", "5", "6");
        List<List<String>> nestedList = new ArrayList<>();
        nestedList.add(list1);
        nestedList.add(list2);

        // flatMap里面对二级list转为stream
        int max = nestedList.stream().flatMapToInt(s -> s.stream().mapToInt(Integer::parseInt)).max().orElse(0);
        System.out.println(max);
    }
}

