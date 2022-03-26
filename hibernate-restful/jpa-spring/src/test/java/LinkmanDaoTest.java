import cn.itcast.dao.CustomerDao;
import cn.itcast.dao.LinkmanDao;
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
 * @date 2022/3/19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class LinkmanDaoTest {

    @Autowired
    private LinkmanDao linkmanDao;

    @Autowired
    private CustomerDao customerDao;

    @Test
    @Transactional
    @Rollback(false)
    public void createTest1() {

        /**
         * 不以视频为准，如果同时新建保存一的一方和多的一方，不用给一的一方add(多的一方)；反正都是在多的一方设置关系。
         */
        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("Edward");

        Customer customer = new Customer();
        customer.setCustName("Haland");
        customer.setCustIndustry("Football");

        linkMan.setCustomer(customer);

        customerDao.save(customer);
        linkmanDao.save(linkMan);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void createTest2() {

        // 现成的一方
        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("Falk");

        Optional<Customer> customer = customerDao.findById(1L);
        linkMan.setCustomer(customer.get());

        linkmanDao.save(linkMan);
    }

    @Test
    @Transactional
    public void findById() {

        Optional<LinkMan> linkman = linkmanDao.findById(1L);
        linkman.ifPresent(man -> System.out.println(man.getCustomer()));
    }
}
