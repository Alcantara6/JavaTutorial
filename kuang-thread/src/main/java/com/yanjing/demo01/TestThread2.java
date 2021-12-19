package com.yanjing.demo01;

/**
 * @author yanjing
 * @date 2021/12/16
 */
// 继承Thread类方式网图下载
public class TestThread2 extends Thread {

    private String url;
    private String name;


    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    // 下载图片线程的执行体
    @Override
    public void run() {

        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载图片：" + name);
    }

    public static void main(String[] args) {

        TestThread2 t1 = new TestThread2("http://n.sinaimg.cn/sinakd2020626s/600/w700h700/20200626/548a-ivmqpck1430480.jpg", "1.jpg");
        TestThread2 t2 = new TestThread2("http://n.sinaimg.cn/sinakd2020626s/600/w700h700/20200626/3ad1-ivmqpck1430479.jpg", "2.jpg");
        TestThread2 t3 = new TestThread2("http://n.sinaimg.cn/sinakd2020626s/600/w700h700/20200626/0939-ivmqpck1430496.jpg", "3.jpg");

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 执行体
            }
        }).start();

        t1.start();
        t2.start();
        t3.start();
    }
}