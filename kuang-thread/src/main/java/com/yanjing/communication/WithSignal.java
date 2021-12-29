package com.yanjing.communication;

/**
 * @author yanjing
 * @date 2021/12/29
 * 测试生产者消费者问题： 信号灯法，标志位解决
 */
public class WithSignal {

    public static void main(String[] args) {

        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

// 生产者 --> 演员
class Player extends  Thread {

    TV tv;

    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {

            if (i % 2 == 0) {

                this.tv.play("快乐大本营播放中...");
            } else {

                this.tv.play("广告，抖音： 记录美好生活");
            }
        }
    }
}

// 消费者 --> 观众
class Watcher extends Thread {

    TV tv;

    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {

            tv.watch();
        }
    }
}

// 产品 --> 节目
class TV {

    // 演员表演，观众等待
    // 观众观看，演员等待
    String voice;
    boolean isPlaying = true;

    // 表演
    public synchronized void play(String voice) {

        if (!isPlaying) {

            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了：" + voice);
        this.notifyAll();
        this.voice = voice;
        this.isPlaying = !this.isPlaying;
    }

    // 观看
    public synchronized void watch() {

        if (isPlaying) {

            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观众观看了：" + voice);
        // 通知演员表演
        this.notifyAll();
        this.isPlaying = !isPlaying;
    }
}