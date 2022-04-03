package com.yanjing.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yanjing
 * @date 2022/3/27
 */
public class StreamApi {

    public void of() {


        Stream<String> stringStream = Stream.of("a", "b", "c");
        ArrayList<Object> o1 = new ArrayList<>();
    }

    public void empty() {
        Stream<Object> empty = Stream.empty();
    }

    public void concat() {

        Stream<String> a = Stream.of("a", "b", "c");
        Stream<String> b = Stream.of("d", "e");
        Stream<String> c = Stream.concat(a, b);
    }

    public void max() {
        Stream<Integer> integerStream = Stream.of(2, 2, 100, 5);
        Optional<Integer> max = integerStream.max(Integer::compareTo);
    }

    public void maxCustom() {
        Stream<Integer> integerStream = Stream.of(2, 2, 100, 5);
        Optional<Integer> max = integerStream.max((x, y) -> x.intValue() < y.intValue() ? -1 : (x.equals(y) ? 0 : 1));
    }

    public void findFirst() {

        Stream<String> stringStream = Stream.of("a", "b", "c", "b");
        Optional<String> first = stringStream.findFirst();
    }

    // 获取 Stream 中的某个元素，如果是串行情况下，一般都会返回第一个元素，并行情况下就不一定了。
    public void findAny() {

        Stream<String> stringStream = Stream.of("a", "b", "c", "b");
        stringStream.findAny();
    }

    public void count() {

        Stream<String> stringStream = Stream.of("a", "b", "c", "b");
        stringStream.count();
    }

    // 在这个通道中对 Stream 的每个元素执行对应的操作
    public void peek() {

        Stream<String> stringStream = Stream.of("a", "b", "c");
        List<String> list = stringStream.peek(e -> System.out.println(e.toUpperCase())).collect(Collectors.toList());
    }

    // forEach 执行之后，这个 Stream 就真的被消费掉了，之后这个 Stream 流就没有了，不可以再对它进行后续操作了
    public void forEach() {

        Stream<String> stringStream = Stream.of("a", "b", "c");
        stringStream.forEach(e -> System.out.println(e.toUpperCase()));
    }

    // 并行时，有顺序保证的，也就是对 Stream 中元素按插入时的顺序进行消费
    public void forEachOrdered() {

        Stream<String> stringStream = Stream.of("a", "b", "c");
        stringStream.parallel().forEachOrdered(e -> System.out.println(e.toUpperCase()));
    }

    public void limit() {

        Stream<String> stringStream = Stream.of("a", "b", "c");
        stringStream.limit(2).forEach(e -> System.out.println(e));
    }

    public void skip() {

        Stream<String> stringStream = Stream.of("a", "b", "c");
        stringStream.skip(2).forEach(e -> System.out.println(e));
    }

    public void distinct() {

        Stream<String> stringStream = Stream.of("a", "b", "c", "b");
        stringStream.distinct().forEach(e -> System.out.println(e));
    }

    public void sorted() {

        Stream<String> stringStream = Stream.of("a", "c", "b");

    }
}

