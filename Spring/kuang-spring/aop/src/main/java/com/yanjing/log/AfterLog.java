package com.yanjing.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author yanjing
 * @date 2021/8/20
 */
public class AfterLog implements AfterReturningAdvice {

    /**
     *
     * @param returnValue 返回值
     * @param method 被调用的方法
     * @param args 被调用的方法的对象的参数
     * @param target 被调用的目标对象
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

        System.out.println("执行了" + method.getName() + "方法，返回结果为：" + returnValue);
    }
}
