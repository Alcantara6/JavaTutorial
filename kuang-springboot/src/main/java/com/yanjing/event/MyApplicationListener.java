package com.yanjing.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author yanjing
 * @date 2023/7/17
 */
@Component
public class MyApplicationListener implements ApplicationListener<CustomEvent<String>> {

    @Override
    public void onApplicationEvent(CustomEvent<String> event) {
        System.out.println("实现接口事件触发" + event.getMsg());
    }
}
