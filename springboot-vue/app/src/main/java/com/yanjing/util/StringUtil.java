package com.yanjing.util;

import java.util.Random;

/**
 * @author yanjing
 * @date 2021/11/25
 */
public class StringUtil {

    public static String randomString(int length) {

        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        // TODO: StringBuilder和StringBuffer的区别
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(base.length());
            sb.append(base.charAt(index));
        }
        return sb.toString();
    }
}
