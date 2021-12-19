package com.yanjing.demo01;

/**
 * @author yanjing
 * @date 2021/12/18
 * 模拟网络延时
 */
public class TestSleep implements Runnable {

    private int ticketNums = 10;

    @Override
    public void run() {

        while (true) {

            if (ticketNums <= 0) {

                break;
            }
            // 模拟延时
            try {

                Thread.sleep(100);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
            ticketNums--;
            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNums + "张票");
        }
    }

    public static void main(String[] args) {

        TestSleep ticket = new TestSleep();

        new Thread(ticket, "学生").start();
        new Thread(ticket, "农名工").start();
        new Thread(ticket, "黄牛").start();
    }
}
