import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author yanjing
 * @date 2022/3/1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CustomerDaoTest {

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testFindById() {

        Optional<Customer> customer = customerDao.findById(1L);
        assertThat(customer.get().getCustId(), Matchers.is(1L));
    }

    @Test
    public void testFindByCustNameAndCustIndustry() {

        List<Customer> customers = customerDao.findByCustNameAndCustIndustry("Thiago", "Sports");
        System.out.println(customers);
    }

    @Test
    @Transactional   // 需要手动事务
    @Rollback(false) // Rollback默认是true
    public void testUpdateCustomer() {
        customerDao.updateCustomer(1L, "Thiago6");
    }
}
