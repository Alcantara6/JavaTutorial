package com.yanjing.Lock;

/**
 * @author yanjing
 * @date 2021/12/18
 */
public class DeadLock {

    public static void main(String[] args) {

        Makeup g1 = new Makeup(0, "灰姑娘");
        Makeup g2 = new Makeup(1, "白雪公主");

        g1.start();
        g2.start();

    }
}

// 口红
class Lipstick {

}

class Mirror {

}

class Makeup extends Thread {

    // 需要的资源只有一份
    static final Lipstick lipstick = new Lipstick();
    static final Mirror mirror = new Mirror();

    int choice;
    String girlName;

    public Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {

        try {
            // makeup();
            // makeup2();
            makeup3();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 化妆，互相持有对方的锁，需要拿到对方的资源
    private void makeup() throws InterruptedException {

        if (choice == 0) {

            synchronized (lipstick) {

                System.out.println(this.girlName + "获取口红的锁");

                // 一秒后想要获得镜子
                Thread.sleep(1000);

                synchronized (mirror) {

                    System.out.println(this.girlName += "获得镜子的锁");
                }
            }
        } else {


            synchronized (mirror) {

                System.out.println(this.girlName + "获取镜子的锁");

                // 2秒后想要获得口红
                Thread.sleep(2000);

                synchronized (lipstick) {

                    System.out.println(this.girlName += "获得口红的锁");
                }
            }
        }
    }

    // 化妆，拿了口红，用完放回去，再去拿镜子
    private void makeup2() throws InterruptedException {

        if (choice == 0) {

            synchronized (lipstick) {

                System.out.println(this.girlName + "获取口红的锁");

                // 一秒后想要获得镜子
                Thread.sleep(1000);
            }

            synchronized (mirror) {

                System.out.println(this.girlName += "获得镜子的锁");
            }
        } else {


            synchronized (mirror) {

                System.out.println(this.girlName + "获取镜子的锁");

                // 2秒后想要获得口红
                Thread.sleep(2000);
            }

            synchronized (lipstick) {

                System.out.println(this.girlName += "获得口红的锁");
            }
        }
    }

    // 安全序列，P1,P2，P3
    private void makeup3() throws InterruptedException {

        if (choice == 0) {

            synchronized (lipstick) {

                System.out.println(this.girlName + "获取口红的锁");

                // 一秒后想要获得镜子
                Thread.sleep(1000);

                synchronized (mirror) {

                    System.out.println(this.girlName += "获得镜子的锁");
                }
            }
        } else {


            synchronized (lipstick) {

                System.out.println(this.girlName + "获取口红的锁");

                // 一秒后想要获得镜子
                Thread.sleep(1000);

                synchronized (mirror) {

                    System.out.println(this.girlName += "获得镜子的锁");
                }
            }
        }
    }
}