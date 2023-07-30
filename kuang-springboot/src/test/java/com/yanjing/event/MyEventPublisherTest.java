package com.yanjing.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * https://www.baeldung.com/spring-events
 * @author yanjing
 * @date 2023/7/17
 */
@SpringBootTest
class MyEventPublisherTest {

    @Autowired
    private MyEventPublisher publisher;

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void testPublish() {
        publisher.pushListener("hello world!");
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}