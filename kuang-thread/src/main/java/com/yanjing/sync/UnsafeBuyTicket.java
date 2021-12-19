package com.yanjing.sync;

/**
 * @author yanjing
 * @date 2021/12/18
 */
public class UnsafeBuyTicket {

    public static void main(String[] args) {

        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket, "苦逼的我").start();
        new Thread(buyTicket, "牛逼的你们").start();
        new Thread(buyTicket, "可恶的黄牛党").start();

    }
}

class BuyTicket implements Runnable {

    private int ticketNums = 10;
    private boolean isTicketLeft = true;

    @Override
    public void run() {

        while (isTicketLeft) {

            // 睡一下，这期间让出CPU使用权
            // 不能在buy方法里面睡，因为sleep不释放锁，那样整个while循环会被锁住，别的线程进不来
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // buy方法被锁住，确保ticketNums同步
            buy();
            // 锁释放
        }
    }

    // 同步方法，对象的锁，也就是this
    private synchronized void buy() {

        if (ticketNums <= 0) {

            isTicketLeft = false;
            return;
        }

        System.out.println(Thread.currentThread().getName() + "拿到" + ticketNums--);
    }
}
