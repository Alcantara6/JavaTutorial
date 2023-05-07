package com.yanjing.io;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author yanjing
 * @date 2023/4/2
 */
public class FileReadWrite {

    private static final List<User> USERS = Arrays.asList(
            new User(1, "zhangsan", 12),
            new User(2, "lisi", 23)
    );

    public static void main(String[] args) {

        File file = write();
        directory();
        read(file);
        // delete file
        // boolean delete = file.delete();
    }

    private static File write() {
        File file = new File("a/b/myCode.txt");
        // File, FileWriter, BufferedWriter
        try {
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (User user : USERS) {
                bufferedWriter.write(user.toString() + "\n");
                // 强制缓冲区立即写入
                bufferedWriter.flush();
            }
            bufferedWriter.close();
            return file;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static File directory() {
        // Dir
        File dir = new File("a/c");
        dir.mkdir();
        if (dir.isDirectory()) {
            String[] dirContents = dir.list();
            for (String content : dirContents) {
                System.out.println(content);
            }
        }
        System.out.println(dir.getAbsolutePath());
        return dir;
    }

    private static void read(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
