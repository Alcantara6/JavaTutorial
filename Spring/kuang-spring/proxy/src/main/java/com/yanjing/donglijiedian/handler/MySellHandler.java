package com.yanjing.donglijiedian.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author yanjing
 * @date 2021/8/17
 * 1. 调用目标方法
 * 2. 功能增强
 */
public class MySellHandler implements InvocationHandler {

    private final Object target;

    // 传入是谁的对象,就给谁创建代理
    public MySellHandler(Object target) {

        this.target = target;
    }

    /**
     * 参数都是jdk直接传入
     * @param proxy 来自newProxyInstance
     * @param method 来自proxy.method调用时的method
     * @param args 来自proxy.method调用时传入的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object res = null;

        // 调用目标方法
        res = method.invoke(target, args);

        // 增强功能
        if (res != null) {

            Float price = (Float) res;
            price = price + 25;
            res = price;
        }

        System.out.println("淘宝商家，给你返一个优惠券，或者红包");

        return res;
    }
}
