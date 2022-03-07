package com.yanjing.cron;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @author yanjing
 * @date 2022/3/7
 */
@Component
@EnableAsync
public class AsyncScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(AsyncScheduledTasks.class);

    /**
     * fixedDelay：固定延迟执行。距离上一次调用成功后2秒才执。
     */
    @Async
    @Scheduled(fixedDelay = 2000)
    public void reportCurrentTimeWithFixedDelay() {
        try {
            TimeUnit.SECONDS.sleep(3);
            log.info("Async Fixed Delay Task : The time is now {}", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
