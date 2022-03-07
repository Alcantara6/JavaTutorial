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

    @Query(value = "update Customer set custName = ?2 where custId = ?1")
    @Modifying
    public void updateCustomer(long id, String name);
}
