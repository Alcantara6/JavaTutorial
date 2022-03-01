import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}
