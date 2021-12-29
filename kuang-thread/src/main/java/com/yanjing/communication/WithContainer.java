package com.yanjing.communication;

/**
 * @author yanjing
 * @date 2021/12/28
 * 管程法，用一个缓冲池
 */
public class WithContainer {

    public static void main(String[] args) {


        SynContainer container = new SynContainer();

        new Producer(container).start();
        new Consumer(container).start();
    }
}

class Producer extends Thread {

    SynContainer synContainer;

    public Producer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {

            // System.out.println("生产了第" + i + "只鸡" );
            synContainer.push(new Chicken(i));
        }
    }
}

class Consumer extends Thread {

    SynContainer synContainer;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {

            System.out.println("消费了id为" + synContainer.pop().getId() + "的鸡");
        }
    }
}

class SynContainer {

    // 需要一个容器大小
    Chicken[] chickens = new Chicken[10];

    // 从0开始
    int index = 0;

    // 生产者放入产品
    // 这个synchronized只针对于多个生产者push的同步问题，与消费者无关
    public synchronized void push(Chicken chicken) {


        // 评论区： 补充一点， 判断count ==10或0的那一句，最好不要用if，应该用while，否则当有多个消费者的时候，会出现脏判断的
        // 因为：if语句中醒来的线程 不会再一次进行判断了 而while会重新再判断
        // 如果容器满了，就需要等待消费者消费
        while (index == chickens.length) {

            // 通知消费者，生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[index] = chicken;
        index++;
        System.out.println("容器现在最后一只鸡的id是" + chicken.getId());
        // 通知消费者的线程可以醒了
        // 可以通知消费者消费了
        this.notifyAll();
    }

    // 这个synchronized只针对于多个消费者push的同步问题，与生产者无关
    public synchronized Chicken pop() {

        // 判断能否消费
        while (index == 0) {

            // 等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        index--;
        // 通知生产者的线程可以醒了
        Chicken chicken = chickens[index];
        this.notifyAll();
        return chicken;
    }
}

class Chicken {

    private int id;

    public Chicken(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}