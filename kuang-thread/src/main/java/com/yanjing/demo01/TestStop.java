package com.yanjing.demo01;

/**
 * @author yanjing
 * @date 2021/12/18
 * 1. 建议线程正常停止----> 利用次数，不建议死循环
 * 2. 建议使用标志位
 * 3. 不要使用stop或destroy等过时或者JDK不建议使用的方法
 */
public class TestStop implements Runnable {

    private boolean flag = true;

    @Override
    public void run() {

        int i = 0;
        while (flag) {

            System.out.println("run....Thread" + i++);
        }
    }

    public static void main(String[] args) {

        TestStop testStop = new TestStop();
        new Thread(testStop).start();

        for (int i = 0; i < 1000; i++) {

            System.out.println("main" + i);
            if (i ==900) {

                testStop.stop();
                System.out.println("线程该停止了");
            }
        }
    }

    private void stop() {

        flag = false;
    }
}
