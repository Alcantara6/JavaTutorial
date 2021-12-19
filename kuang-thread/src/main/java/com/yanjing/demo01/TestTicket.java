package com.yanjing.demo01;

/**
 * @author yanjing
 * @date 2021/12/18
 */
// 多个线程同时操作一个对象
// 买火车票的例子

// 发现问题：多个线程操作同一个资源的情况下，线程不安全，数据紊乱
public class TestTicket implements Runnable {

    private int ticketNums = 10;

    @Override
    public void run() {

        while (true) {

            if (ticketNums <= 0) {

                break;
            }
            // 模拟延时
            // Sleep的存在导致各个线程之间ticketNums的变化不同步
            try {

                Thread.sleep(200);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
            ticketNums--;
            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNums + "张票");
        }
    }

    public static void main(String[] args) {

        TestTicket ticket = new TestTicket();

        new Thread(ticket, "学生").start();
        new Thread(ticket, "农名工").start();
        new Thread(ticket, "黄牛").start();
    }
}
