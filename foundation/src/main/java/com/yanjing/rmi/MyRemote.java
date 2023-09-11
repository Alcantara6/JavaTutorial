package com.yanjing.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author yanjing
 * @date 2023/5/27
 */
public interface MyRemote extends Remote {

    /**
     *
     * @param msg 必须是primitive类型或Serializable
     * @return 必须是primitive类型或Serializable
     * @throws RemoteException 每个远程调用都会被认为是有风险的，这样声明会强迫客户端要注意到这件事
     */
   String sayHello(String msg) throws RemoteException;
}
