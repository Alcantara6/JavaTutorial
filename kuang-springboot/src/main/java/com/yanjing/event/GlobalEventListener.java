package com.yanjing.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author yanjing
 * @date 2023/7/17
 */
public class GlobalEventListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("global event: " + event.getClass().getName());
    }
}
