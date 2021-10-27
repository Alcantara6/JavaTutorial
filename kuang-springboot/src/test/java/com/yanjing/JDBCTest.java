package com.yanjing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author yanjing
 * @date 2021/10/26
 */
@SpringBootTest
public class JDBCTest {

    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {

        // 查看一下默认的数据源： class com.zaxxer.hikari.HikariDataSource
        System.out.println(dataSource.getClass());

        // 获得数据库连接 HikariProxyConnection@740982099 wrapping com.mysql.cj.jdbc.ConnectionImpl@46524ebe
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        connection.close();
    }
}
