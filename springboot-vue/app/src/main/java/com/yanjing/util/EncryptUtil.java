package com.yanjing.util;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author yanjing
 * @date 2022/6/4
 */
public class EncryptUtil {

    public static final String ALGORITHM = "md5";

    public static final int HASH_TIMES = 2;

    public static String generateSalt() {
        return new SecureRandomNumberGenerator().nextBytes().toString();
    }

    public static String encrypt(String password, String salt) {

        return new SimpleHash(ALGORITHM, password, salt, HASH_TIMES).toString();
    }
}
