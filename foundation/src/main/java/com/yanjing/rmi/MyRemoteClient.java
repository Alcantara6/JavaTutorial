package com.yanjing.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author yanjing
 * @date 2023/5/27
 */
public class MyRemoteClient  {

    public static void main(String[] args) {
        new MyRemoteClient().go();
    }

    // Remote Hello，是注册的名称
    public void go() {
        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
            String res = service.sayHello("world");
            System.out.println(res);
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            throw new RuntimeException(e);
        }
    }

}
