package com.yanjing.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yanjing
 * @date 2021/8/17
 */
// 等会儿我们会用这个类，自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    // 被代理的接口
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    // 生成得到代理类
    public Object getProxy() {

        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    // 处理代理实例，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 动态代理的本质，就是使用反射机制实现
        seeHouse();
        Object result = method.invoke(target, args);
        fare();
        return result;
    }

    private void seeHouse() {

        System.out.println("中介带看房子");
    }

    private void fare() {

        System.out.println("收中介费");
    }
}
