package com.yanjing.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yanjing
 * @date 2023/7/17
 */
@Component
public class MyEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void pushListener(String msg) {
        applicationEventPublisher.publishEvent(new CustomEvent<>(this, msg, true));
    }
}
