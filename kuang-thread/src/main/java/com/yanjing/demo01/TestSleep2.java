package com.yanjing.demo01;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yanjing
 * @date 2021/12/18
 * 模拟网络延时和倒计时
 */
public class TestSleep2 {

    public static void main(String[] args) throws InterruptedException {
        TestSleep2.tenDown();
    }

    public static void tenDown() throws InterruptedException {

        int num = 10;

        while (true) {

            Thread.sleep(1000);
            System.out.println(num--);
            if (num <= 0 ) {
                return;
            }
        }
    }

    public static void currentTime() {

        Date startTime = new Date(System.currentTimeMillis());

        while (true) {

            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
