package com.yanjing.sync;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yanjing
 * @date 2021/12/28
 */
public class TestLock {

    public static void main(String[] args) {

        TestLock2 testLock2 = new TestLock2();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}

class TestLock2 implements Runnable {

    int nums = 10;

    // 定义lock锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        while (true) {

            try {

                lock.lock(); // 加锁
                if (nums > 0) {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(nums--);
                } else {

                    break;
                }
            } finally {

                // 解锁
                lock.unlock();
            }

        }
    }
}
