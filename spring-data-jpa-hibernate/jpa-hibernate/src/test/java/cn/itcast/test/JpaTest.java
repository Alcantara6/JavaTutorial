package cn.itcast.test;

import cn.itcast.domain.Customer;
import cn.itcast.utils.JpaUtils;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author yanjing
 * @date 2022/2/27
 */
public class JpaTest {

    // JPA的操作步骤
    @Test
    public void testSave() {
        // 1. 根据持久化单元名称，加载配置文件创建工厂（实体管理类工厂）对象

        /**
         * EntityManagerFactory ：获取EntityManager对象，方法：createEntityManager
         * factory内部维护的很多的内容，包括数据库信息、缓存信息、实体管理器对象，
         * 在创建EntityManagerFactory的过程中会根据配置（create）创建数据库表
         * EntityManagerFactory的创建过程比较浪费资源，是线程安全的对象
         * 如何解决EntityManagerFactory的创建过程浪费资源（耗时）的问题？
         * 思路：创建一个公共的EntityManagerFactory的对象，静态代码块的形式创建EntityManagerFactory
         * (这里可能不太好，其实就是一个单例设计，可以用IOC)
         */
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
        // 2. 通过实体管理类工厂获取实体管理器
        EntityManager entityManager = factory.createEntityManager();
        // 3. 获取事务对象，开启事务
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        // 4. 完成增删改查操作
        Customer customer = new Customer();
        customer.setCustName("Thiago");
        customer.setCustIndustry("sports");
        entityManager.persist(customer); // 保存操作
        // 5. 提交事务（回滚事务）
        tx.commit();
        // 6. 释放资源
        entityManager.close();
        factory.close();
    }

    @Test
    public void testFind() {

        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Customer customer = entityManager.find(Customer.class, 1L);
        System.out.println(customer);
        tx.commit();
        entityManager.close();
    }

    @Test
    public void testGetReference() {

        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Customer customer = entityManager.getReference(Customer.class, 1L);
        System.out.println(customer);
        tx.commit();
        entityManager.close();
    }

    @Test
    public void testRemove() {

        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Customer customer = entityManager.getReference(Customer.class, 1L);
        entityManager.remove(customer);
        tx.commit();
        entityManager.close();
    }

    @Test
    public void testUpdate() {

        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Customer customer = entityManager.getReference(Customer.class, 1L);
        customer.setCustIndustry("IT");
        entityManager.merge(customer);
        tx.commit();
        entityManager.close();
    }
}
