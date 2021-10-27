package com.yanjing.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author yanjing
 * @date 2021/8/20
 */
public class BeforeLog implements MethodBeforeAdvice {

    /**
     *
     * @param method 要执行的目标对象的方法
     * @param objects 参数
     * @param target 目标对象
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object target) throws Throwable {

        System.out.println(target.getClass().getName() + "的" + method.getName() + "被执行了");
    }
}
