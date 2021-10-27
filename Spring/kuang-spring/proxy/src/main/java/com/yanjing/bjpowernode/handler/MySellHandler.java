package com.yanjing.bjpowernode.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author yanjing
 * @date 2021/8/17
 */
public class MySellHandler implements InvocationHandler {

    private Object target;

    //传入是谁的对象,就给谁创建代理
    public MySellHandler(Object target) {
        this.target = target;
    }

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
