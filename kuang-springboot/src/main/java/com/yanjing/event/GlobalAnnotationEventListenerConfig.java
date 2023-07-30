package com.yanjing.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * @author yanjing
 * @date 2023/7/17
 */
@Configuration
public class GlobalAnnotationEventListenerConfig {

    @EventListener(classes = {ApplicationEvent.class})
    public void listen(ApplicationEvent event) {
        System.out.println("GlobalAnnotationEventListenerConfig事件触发：" + event.getClass().getName());
    }
}
