package com.yanjing.demo04;

/**
 * @author yanjing
 * @date 2021/8/17
 */
public class Client {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        ProxyInvocationHandler phi = new ProxyInvocationHandler();
        phi.setTarget(userService);
        UserService proxy = (UserService) phi.getProxy();

        proxy.add();
        proxy.update();
        proxy.query();
        proxy.delete();
    }
}
