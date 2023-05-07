package com.yanjing.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yanjing
 * @date 2023/4/5
 */
public class NetSocket {

    private static final String[] adviceList = {"a", "b", "c"};

    public static void main(String[] args) {
        clientReadFromServer();
        clientPrintToServer();
        serverSocketListenClient();
    }

    private static void clientReadFromServer() {
        try {
            Socket chatSocket = new Socket("127.0.0.1", 4242);
            InputStreamReader stream = new InputStreamReader(chatSocket.getInputStream());
            BufferedReader reader = new BufferedReader(stream);
            String advice = reader.readLine();
            System.out.println("Today you should:" + advice);
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void clientPrintToServer() {
        try {
            Socket chatSocket = new Socket("127.0.0.1", 4242);
            PrintWriter writer = new PrintWriter(chatSocket.getOutputStream());
            writer.println("message to send");
            writer.print("another message");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void serverSocketListenClient() {
        try {
            // ServerSocket会监听客户端对这台机器在4242端口上的要求
            ServerSocket serverSocket = new ServerSocket(4242);
            while (true) {
                // 这个方法会停下来等待要求到达之后才会继续
                Socket newSocketToClient = serverSocket.accept();
                // 在没有完成目前用户的响应程序（下面的步骤到close）循环之前它无法回到循环的开始处来处理下一个要求，也就是不能同时处理多个用户
                // ---> 多线程
                PrintWriter writer = new PrintWriter(newSocketToClient.getOutputStream());
                int random = (int)(Math.random() * adviceList.length);
                String advice = adviceList[random];
                writer.println(advice);
                System.out.println(advice);
                writer.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
