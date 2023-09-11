// package com.yanjing.stream;
//
// import org.junit.jupiter.api.Test;
// import org.openjdk.jmh.annotations.*;
//
// import java.util.Arrays;
// import java.util.List;
// import java.util.concurrent.ExecutionException;
// import java.util.concurrent.ForkJoinPool;
// import java.util.concurrent.TimeUnit;
//
// /**
//  * @author yanjing
//  * @date 2022/8/10
//  */
// @BenchmarkMod(Mode.AverageTime)
// @Warmup(iterations = 3, time = 1)
// @Measurement(iterations = 3, time = 1)
// @Threads(4)
// @Fork(1)
// @State(Scope.Benchmark)
// @OutputTimeUnit(TimeUnit.NANOSECONDS)
// public class ParallelStreamTest {
//
//     @Test
//     public void printParallelStream() {
//         List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//         listOfNumbers.stream().forEach(number -> {
//             System.out.println(number + "" + Thread.currentThread().getName());
//         });
//
//         List<Integer> listOfNumbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//         listOfNumbers2.parallelStream().forEach(number -> {
//             System.out.println(number + "" + Thread.currentThread().getName());
//         });
//     }
//
//     @Test
//     public void reduceParallelTest() {
//         ForkJoinPool commonPool = ForkJoinPool.commonPool();
//         System.out.println(commonPool.getParallelism());
//         System.out.println(Runtime.getRuntime().availableProcessors());
//
//         List<Integer> listOfNumbers1 = Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10);
//         int sum1 = listOfNumbers1.stream().reduce(10, Integer::sum);
//         System.out.println(sum1);
//
//         List<Integer> listOfNumbers2 = Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10);
//         int sum2 = listOfNumbers2.parallelStream().reduce(10, Integer::sum);
//         System.out.println(sum2);
//     }
//
//     /**
//      * reduce的identity在parallelStream怎么参与计算的没有搞太清，反正记住parallelStream/reduce的identity只能用0
//      *
//      * @throws ExecutionException
//      * @throws InterruptedException
//      */
//     @Test
//     public void customerThreadPoolTest() throws ExecutionException, InterruptedException {
//         // List<Integer> listOfNumbers = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());
//         List<Integer> listOfNumbers = Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10);
//         ForkJoinPool customThreadPool = new ForkJoinPool(1);
//         Integer sum = customThreadPool.submit(
//                 () -> listOfNumbers.parallelStream().reduce(10, Integer::sum)).get();
//         customThreadPool.shutdown();
//         System.out.println(sum);
//     }
// }
