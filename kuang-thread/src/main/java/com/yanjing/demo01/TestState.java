package com.yanjing.demo01;

/**
 * @author yanjing
 * @date 2021/12/18
 * 测试观察线程的状态
 */
public class TestState {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {

            for (int i = 0; i < 5; i++) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("/////");
        });

        Thread.State state = thread.getState();
        System.out.println(state);

        thread.start();
        state = thread.getState();
        System.out.println(state);

        while (state != Thread.State.TERMINATED) {

            Thread.sleep(100);
            state = thread.getState();
            System.out.println(state);
        }

        // 停止之后不能再启动
        // thread.start();
    }
}
