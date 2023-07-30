package com.yanjing.event;

import org.springframework.context.ApplicationEvent;

/**
 * Spring 4.2之后可以不extends ApplicationEvent
 * @author yanjing
 * @date 2023/7/17
 */
public class CustomEvent<T> extends ApplicationEvent {

    private static final long serialVersionUID = -5317802326797735854L;

    private T msg;
    private boolean success;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public CustomEvent(Object source, T msg, boolean success) {
        super(source);
        this.msg = msg;
        this.success = success;
    }

    public T getMsg() {
        return msg;
    }

    public void setMsg(T msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
