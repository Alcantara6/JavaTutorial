package cn.itcast.dao;

import cn.itcast.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author yanjing
 * @date 2022/3/1
 */
public interface CustomerDao extends JpaRepository<Customer, Long>, JpaSpecificationExecutor {

    // Response也可以是Customer
    public List<Customer> findByCustNameAndCustIndustry(String name, String industry);

    @Query(value = "select * from cst_customer where cust_name = ?1 and cust_industry = ?2", nativeQuery = true)
    public List<Customer> nativeFindByCustNameAndCustIndustry(String name, String industry);

    @Query(value = "update Customer set custName = ?2 where custId = ?1")
    @Modifying
    public void updateCustomer(long id, String name);
}
