package com.yanjing.demo01;

/**
 * @author yanjing
 * @date 2021/12/18
 */
public class TestRunnable implements Runnable {

    @Override
    public void run() {

        // run方法线程体
        for (int i = 0; i < 200; i++) {

            System.out.println("我在看代码" +i);
        }
    }

    public static void main(String[] args) {

        Runnable runnable = new TestRunnable();
        new Thread(runnable).start();

        // main线程，主线程
        for (int i = 0; i < 1000; i++) {

            System.out.println("我在学习多线程--" + i);
        }
    }
}
