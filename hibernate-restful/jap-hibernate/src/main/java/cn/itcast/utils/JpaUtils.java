package cn.itcast.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author yanjing
 * @date 2022/2/27
 * 解决实体管理器工厂的浪费资源和耗时问题
 * 通过静态代码块的形式，当程序第一次访问此工具类时，创建一个公共的实体管理器工厂对象
 * 这里可能不太好，其实就是一个单例设计，可以用IOC
 */
public class JpaUtils {

    private static EntityManagerFactory factory;

    static {

        factory = Persistence.createEntityManagerFactory("myJpa");
    }

    public static EntityManager getEntityManager() {

        return factory.createEntityManager();
    }
}
