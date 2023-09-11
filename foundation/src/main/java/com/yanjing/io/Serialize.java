package com.yanjing.io;

import java.io.*;

/**
 * @author yanjing
 * @date 2022/1/6
 */
public class Serialize {

    public static void main(String[] args) {

        writeUser();
        readUser();
    }

    private static void writeUser() {

        User user = new User();
        user.setId(1);
        user.setName("张三");
        user.setAge(12);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("./stream.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(user);
            System.out.println("序列化成功");
            objectOutputStream.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private static void readUser() {

        try {

            FileInputStream fileInputStream = new FileInputStream("./stream.txt");
            ObjectInputStream stream = new ObjectInputStream(fileInputStream);
            try {
               User user = (User) stream.readObject();
               System.out.println("反序列化成功");
               System.out.println(user);
               stream.close(); // FileInputStream会自动跟着关掉
            } catch (ClassNotFoundException e) {

                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
