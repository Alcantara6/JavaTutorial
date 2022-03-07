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
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(new File("./stream.txt")));
            stream.writeObject(user);
            System.out.println("序列化成功");
            stream.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private static void readUser() {

        try {

            ObjectInputStream stream = new ObjectInputStream(new FileInputStream("./stream.txt"));
            try {
               User user = (User) stream.readObject();
               System.out.println("反序列化成功");
               System.out.println(user);
            } catch (ClassNotFoundException e) {

                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
