package com.yanjing.exception;

import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;

import java.awt.*;
import java.io.IOException;

/**
 * @author yanjing
 * @date 2023/3/25
 */
public class HeadFirstExceptionTest {

    public static void main(String[] args) {
        HeadFirstExceptionTest test = new HeadFirstExceptionTest();
        int res = test.testFinally();
        System.out.println(res);
    }

    // throw exception要抛出
    public void taskRisk(String x) throws IOException {
        if (x == null) {
            throw new IOException();
        }
    }

    public void testRuntime(String x) {
        // RuntimeException的子类异常不是必须抛出
        int a = Integer.parseInt(x);
    }

    public int testFinally() {
        try {
            int x = 1 / 0;
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 2;
        } finally {
            System.out.println("exec code in finally before return");
        }
    }
}
