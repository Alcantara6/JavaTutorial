package com.yanjing;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author yanjing
 * @date 2021/11/3
 */
public class EncryptUtil {

    public static void main(String[] args) {

        encrypt("123");
    }

    public static String encrypt(String password) {

        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String alogrithm = "md5";   // 加密算法

        String encryptedPassword = new SimpleHash(alogrithm, password, salt, times).toString();

        System.out.printf("原始密码是 %s , 盐是： %s, 运算次数是： %d, 运算出来的密文是：%s ", password, salt, times, encryptedPassword);

        return encryptedPassword;
    }
}
