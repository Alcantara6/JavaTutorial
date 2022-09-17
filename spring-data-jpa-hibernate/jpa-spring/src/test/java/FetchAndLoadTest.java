import cn.itcast.dao.CustomerDao;
import cn.itcast.dao.LinkmanDao;
import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author yanjing
 * @date 2022/9/17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Slf4j
public class FetchAndLoadTest {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkmanDao linkmanDao;

    @Test
    @Transactional
    @Rollback(false)
    public void batchCreateCustomer() {
        for (int i = 0; i < 100000; i++) {
            Customer customer = new Customer();
            customer.setCustName("player" + i + "plus");
            customer.setCustIndustry("Football" + i + "plus");
            customerDao.save(customer);
        }
    }

    @Test
    @Transactional
    @Rollback(false)
    public void batchCreateLkm() {

        for (int i = 1; i < 100000; i++) {
            // 现成的一方
            LinkMan linkMan = new LinkMan();
            linkMan.setLkmName("Falk" + i);

            Customer customer = customerDao.findById(100000L % i).orElse(customerDao.findById(1L).orElse(null));
            if (customer != null) {
                linkMan.setCustomer(customer);
            }
            linkmanDao.save(linkMan);
        }
    }

    /**
     * 执行SQL，customer会join linkMan
     */
    @Test
    @Transactional
    @Rollback(false)
    public void findAllWithEntityGraphTest() {

        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        List<Customer> allCust = customerDao.findAllWithEntityGraphTypeLoad();
        for (Customer customer : allCust) {
            customer.getLinkmans().forEach(linkMan -> {
                sb.append(linkMan.getLkmName()).append("; ");
            });
        }
        log.info("cost time {}", System.currentTimeMillis() - start);
    }
}
