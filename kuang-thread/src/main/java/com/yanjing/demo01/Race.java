package com.yanjing.demo01;

/**
 * @author yanjing
 * @date 2021/12/18
 */
// 模拟龟兔赛跑
public class Race implements Runnable {

    // 胜利者： 静态变量，多个线程共同访问
    private static String winner;

    @Override
    public void run() {

        // i是栈内局部变量，每个线程独享
        for (int i = 1; i <= 100; i++) {

            if (shouldRabbitSleep(i)) {

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            boolean isGameOver = gameOver(i);
            if (isGameOver) {

                break;
            }
            System.out.println(Thread.currentThread().getName() + "-->跑了" + i + "步");
        }
    }

    private boolean gameOver(int steps) {

        if (winner != null) {

            return true;
        }
        if (steps >= 100) {

            winner = Thread.currentThread().getName();
            System.out.println("winner is " + winner);
            return true;
        }
        return false;
    }

    private boolean shouldRabbitSleep(int steps) {

        return Thread.currentThread().getName().equals("兔子") && steps % 10 == 0;
    }

    public static void main(String[] args) {

        Race race = new Race();
        // 赛道race实例只有一个，多个线程共享
        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }
}
