package com.yanjing.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Arrays;
import java.util.List;

/**
 * @author yanjing
 * @date 2023/7/17
 */
@Component
public class MyAnnotationListener {

    /**
     * SPEL, the event handler will only be invoked when success is true
     *
     *  If we return a non-null value from a method annotated with @EventListener as the result,
     *  Spring Framework will send that result as a new event for us.
     *  org.springframework.context.PayloadApplicationEvent
     *  Moreover, we can publish multiple new events by returning them in a collection as the result of event processing.
     *
     * @param event
     */
    @EventListener(condition = "#event.success")
    public List<String> listen(CustomEvent<String> event) {
        System.out.println("注解监听器有返回类型：" + event.getMsg());
        return Arrays.asList(event.getMsg(), event.getMsg() + "plus");
    }

    @EventListener(condition = "#event.success")
    public void listen2(CustomEvent<String> event) {
        System.out.println("注解监听器返回void：" + event.getMsg());
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK, fallbackExecution = true)
    public void transactionalListen(CustomEvent<String> event) {
        System.out.println("事务的注解监听器：" + event.getMsg());
    }
}
