package com.yanjing.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author yanjing
 * @date 2021/12/20
 */
public class MybatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static {

        // 读取配置，开启事务
        String resources = "mybatis-config.xml";
        InputStream mybatisConfigAsStream = null;
        try {
            mybatisConfigAsStream = Resources.getResourceAsStream(resources);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(mybatisConfigAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession() {

        return sqlSessionFactory.openSession(true);
    }
}
