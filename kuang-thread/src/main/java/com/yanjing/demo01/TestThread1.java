package com.yanjing.demo01;

/**
 * @author yanjing
 * @date 2021/12/16
 */

// 创建线程方式一：继承Thread类，重写run方法，调用start开启线程
// 总结：线程开启不一定立即执行，由CPU调度执行
public class TestThread1 extends Thread {

    @Override
    public void run() {

        // run方法线程体
        for (int i = 0; i < 200; i++) {

            System.out.println("我在看代码" +i);
        }
    }

    public static void main(String[] args) {

        // 闯将一个线程对象
        TestThread1 testThread1 = new TestThread1();
        // 调用start()方法开启线程
        testThread1.start();

        // main线程，主线程
        for (int i = 0; i < 1000; i++) {

            System.out.println("我在学习多线程--" + i);
        }
    }
}
