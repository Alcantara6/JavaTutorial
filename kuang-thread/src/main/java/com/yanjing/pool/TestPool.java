package com.yanjing.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yanjing
 * @date 2021/12/29
 */
public class TestPool {

    public static void main(String[] args) {

        // 1. 创建服务/线程池
        ExecutorService extService = Executors.newFixedThreadPool(10);

        extService.execute(new MyRunnable());
        extService.execute(new MyRunnable());
        extService.execute(new MyRunnable());
        extService.execute(new MyRunnable());

        extService.shutdown();
    }
}