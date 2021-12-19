package com.yanjing.sync;

import java.util.ArrayList;

/**
 * @author yanjing
 * @date 2021/12/18
 */
public class UnsafeList {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {

            new Thread(() -> {

                synchronized (list) {

                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        System.out.println(list.size());
    }
}
