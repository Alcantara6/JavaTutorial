import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
    @Transactional
    @Rollback(false)
    public void create() {
        Customer customer = new Customer();
        customer.setCustName("Thiago666");
        customer.setCustIndustry("Football");

        customerDao.save(customer);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testFindById() {

        Optional<Customer> customer = customerDao.findById(1L);
        System.out.println(customer.get().getLinkmans().size());
    }

    @Test
    public void testOptionalList() {
        Optional<List<Customer>> football = customerDao.findByCustIndustry("Football");
        System.out.println(football.get());
    }

    @Test
    public void testFindByCustNameAndCustIndustry() {

        List<Customer> customers = customerDao.findByCustNameAndCustIndustry("Thiago6", "sports");
        System.out.println(customers);
    }

    @Test
    public void testNativeFindByCustNameAndCustIndustry() {

        List<Customer> customers = customerDao.nativeFindByCustNameAndCustIndustry("Thiago6", "sports");
        System.out.println(customers);
    }

    @Test
    @Transactional   // 需要手动事务
    @Rollback(false) // Rollback默认是true
    public void testUpdateCustomer() {
        customerDao.updateCustomer(1L, "Thiago6");
    }
}
