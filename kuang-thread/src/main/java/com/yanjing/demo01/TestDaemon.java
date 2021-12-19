package com.yanjing.demo01;

/**
 * @author yanjing
 * @date 2021/12/18
 * 虚拟机不用等待用户线程执行完毕，只要用户线程执行完毕，则守护线程也会结束
 * 如后台记录操作日志、监控内存、垃圾回收等待
 */
public class TestDaemon {

    public static void main(String[] args) {

        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true); // 默认用户线程是false
        thread.start(); // 上帝守护线程启动

        new Thread(you).start(); // 你 用户线程启动...
    }
}

class God implements Runnable {


    @Override
    public void run() {

        while (true) {

            System.out.println("上帝保佑着你");
        }
    }
}

class You implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 36500; i++) {

            System.out.println("你一生都开心得活着");
        }
        System.out.println("-=========goodbye! world!===========");
    }
}