package com.yanjing.demo03;

/**
 * @author yanjing
 * @date 2021/8/17
 */
public class Client {

    public static void main(String[] args) {

        // 真实角色
        Host host = new Host();

        // 代理角色： 现在没有
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        // 通过调用程序处理角色来处理我们要调用的接口对象！
        pih.setTarget(host);
        Rent proxy = (Rent) pih.getProxy();
        proxy.rent();
    }

}
