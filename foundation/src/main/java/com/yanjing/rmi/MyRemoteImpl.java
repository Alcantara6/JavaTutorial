package com.yanjing.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author yanjing
 * @date 2023/5/27
 * 编译server和client java文件
 * 以下操作都在classPath中进行：
 * 执行rmic com.yanjing.rmi.MyRemoteImpl生成客户端用的stub （实际场景：把stub类交给用户或通过web服务下载）
 * rmiregistry，启动RMI registry
 * 另一个终端：java com.yanjing.rmi.MyRemoteImpl启动服务
 *
 * java com.yanjing.rmi.MyRemoteClient执行客户端
 */
// 继承UnicastRemoteObject称为远程对象，UnicastRemoteObject会处理与远程有关的事情
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    public static void main(String[] args) {
        MyRemoteImpl service = null;
        try {
            service = new MyRemoteImpl();
            // 注册的名称会供客户端查询
            Naming.bind("RemoteHello", service);
        } catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // 父类的构造函数声明了异常，这里必须写出构造函数并处理异常
    public MyRemoteImpl() throws RemoteException {
    }

    @Override
    public String sayHello(String msg) {
        return "Server says" + msg;
    }
}
