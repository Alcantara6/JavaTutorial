package com.yanjing.donglijiedian;

import com.yanjing.donglijiedian.factory.UsbKingFactory;
import com.yanjing.donglijiedian.handler.MySellHandler;
import com.yanjing.donglijiedian.service.UsbSell;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author yanjing
 * @date 2021/8/17
 */
public class MainShop {

    public static void main(String[] args) {

        // 1. 创建目标对象
        UsbSell factory = new UsbKingFactory();

        // 2. 创建InvocationHandler对象
        InvocationHandler handler = new MySellHandler(factory);

        // 3. 创建代理对象
        UsbSell proxy = (UsbSell) Proxy.newProxyInstance(factory.getClass().getClassLoader(),
                factory.getClass().getInterfaces(),
                handler);

        // com.sun.proxy.$Proxy0: 这是jdk动态代理创建的类型
        System.out.println("proxy:" + proxy.getClass().getName());
        // 4. 通过代理执行方法
        float price = proxy.sell(1);
        System.out.println("通过动态代理对象，调用方法：" + price);
    }
}
