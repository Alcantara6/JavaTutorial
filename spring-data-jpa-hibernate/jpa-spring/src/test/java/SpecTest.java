import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

/**
 * @author yanjing
 * @date 2022/3/19
 * 	* Specification ：查询条件
 * 自定义我们自己的Specification实现类
 * 1. root：查询的根对象（查询的任何属性都可以从根对象中获取）
 * 2. CriteriaQuery：顶层查询对象，自定义查询方式（了解：一般不用）
 * 3. CriteriaBuilder：查询的构造器，封装了很多的查询条件(模糊匹配，精准匹配)
 * 封装查询条件: Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb);
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpecTest {

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testOnePredict() {

        Specification<Customer> spec = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                Path<String> custName = root.get("custName");
                return cb.equal(custName, "Thiago");
            }
        };
        Optional<Customer> customer = customerDao.findOne(spec);
        System.out.println(customer);
    }

    @Test
    public void testMultiPredict() {

        Specification<Customer> spec = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                Path<Object> custName = root.get("custName");
                Path<Object> industry = root.get("custIndustry");
                Predicate p1 = cb.equal(custName, "Thiago");
                Predicate p2 = cb.equal(industry, "Football");
                return cb.and(p1, p2);
            }
        };
        Optional<Customer> customer = customerDao.findOne(spec);
        System.out.println(customer);
    }

    /**
     * gt, lt, ge, le, like: 得到path对象，根据path指定比较的参数类型，再去比较
     * path.as(类型的字节码对象)，例如path.as(String.class)
     */
    @Test
    public void testSpecLikeAndSort() {

        Specification<Customer> spec = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                Path<Object> custName = root.get("custName");
                return cb.like(custName.as(String.class), "T%");
            }
        };
        List<Customer> customers = customerDao.findAll(spec, Sort.by(Sort.Direction.DESC, "custId"));
        System.out.println(customers);
    }

    @Test
    public void testPaging() {

        Pageable pageable = PageRequest.of(0, 2);
        Page<Customer> page = customerDao.findAll((Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            Path<Object> custName = root.get("custName");
            return cb.like(custName.as(String.class), "T%");
        }, pageable);
        long total = page.getTotalElements();
        List<Customer> customers = page.getContent();
        int pages = page.getTotalPages();
        System.out.println(total + "," + pages + "," + customers);
    }
}
