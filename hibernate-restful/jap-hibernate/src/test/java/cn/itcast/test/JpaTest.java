package cn.itcast.test;

import cn.itcast.domain.Customer;
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

    // Jpa的操作步骤
    @Test
    public void testSave() {
        // 1. 加载配置文件创建工厂（实体管理类工厂）对象
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
}
