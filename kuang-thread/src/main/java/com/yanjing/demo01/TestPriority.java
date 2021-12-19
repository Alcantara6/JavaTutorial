package com.yanjing.demo01;

/**
 * @author yanjing
 * @date 2021/12/18
 */
public class TestPriority implements Runnable {

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "--->" + Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {

        TestPriority myPriority = new TestPriority();

        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);
        Thread t6 = new Thread(myPriority);


        t2.setPriority(1);

        t3.setPriority(4);

        t4.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // t5.setPriority(-1);
        // t5.start();

        // t6.setPriority(11);
        // t6.start();
    }
}
