/**
 * @author yanjing
 * @date 2022/3/20
 */

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

/**
 * @author yanjing
 * @date 2022/3/1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Slf4j
public class CacheTest {

    @Autowired
    private CustomerDao customerDao;


    /**
     * linkmans使用Lazy load，通过customer.getLinkmans()访问的时候才真正从数据库获取，
     * 这时候已经不在JpaRepository的事务中了，所以要在外层包裹事务，把JPA的事务合并到外层事务中。
     */
    @Test
    @Transactional
    @Rollback(false)
    public void testFindByIdFetchLazy() {

        Customer customer = customerDao.findById(1L).get();
        log.info("linkman is: " + customer.getLinkmans());
    }

    /**
     * 使用了entitygraph，即时加载
     */
    @Test
    public void testFindByIdEntityGraph() {

        Customer customer = customerDao.findByCustName("Thiago");
        log.info("linkman is: " + customer.getLinkmans());
    }
}
