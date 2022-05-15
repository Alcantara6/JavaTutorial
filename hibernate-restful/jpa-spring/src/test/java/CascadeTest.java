import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @author yanjing
 * @date 2022/3/20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CascadeTest {

    @Autowired
    private CustomerDao customerDao;

    /**
     * 级联添加
     */
    @Test
    @Transactional
    @Rollback(false)
    public void createCascadeAdd() {

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("Mendez");

        Customer customer = new Customer();
        customer.setCustName("Mbappe");
        customer.setCustIndustry("Football");

        customer.getLinkmans().add(linkMan);
        // 因为customer放弃了维护权，所以保存时linkman->customer的关联没有建立，
        // 但是link_man表的lkm_cust_id为NOT NULL，会报错，所以这里显式设置
        // 如果没有放弃维护权，就不需要setCustomer
        linkMan.setCustomer(customer);

        customerDao.save(customer);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void createCascadeRemove() {

        Optional<Customer> customer = customerDao.findById(10L);

        customerDao.delete(customer.get());
    }
}
