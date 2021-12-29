package com.yanjing.pool;

import com.yanjing.demo01.WebDownloader;

import java.util.concurrent.*;

/**
 * @author yanjing
 * @date 2021/12/29
 */
public class TestCallable implements Callable<Boolean> {

    private final String url;
    private final String name;

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    // 下载图片线程的执行体
    @Override
    public Boolean call() throws Exception {

        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载图片：" + name);
        return true;
    }



    public static void main(String[] args) throws ExecutionException, InterruptedException {

        TestCallable t1 = new TestCallable("http://n.sinaimg.cn/sinakd2020626s/600/w700h700/20200626/548a-ivmqpck1430480.jpg", "1.jpg");
        TestCallable t2 = new TestCallable("http://n.sinaimg.cn/sinakd2020626s/600/w700h700/20200626/3ad1-ivmqpck1430479.jpg", "2.jpg");
        TestCallable t3 = new TestCallable("http://n.sinaimg.cn/sinakd2020626s/600/w700h700/20200626/0939-ivmqpck1430496.jpg", "3.jpg");


        // 创建执行服务
        ExecutorService extService = Executors.newFixedThreadPool(3);
        // 提交执行
        Future<Boolean> res1 = extService.submit(t1);
        Future<Boolean> res2 = extService.submit(t2);
        Future<Boolean> res3 = extService.submit(t3);
        // 获取结果
        boolean rs1 = res1.get();
        boolean rs2 = res2.get();
        boolean rs3 = res3.get();

        // 关闭服务
        extService.shutdown();
    }
}
