package cn.itcast.dao;

import cn.itcast.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author yanjing
 * @date 2022/3/1
 * https://www.yuque.com/office/yuque/0/2022/docx/436938/1647658728593-750926eb-cc38-4788-872a-63c72a36fdc0.docx?from=https%3A%2F%2Fwww.yuque.com%2Fjinggor%2Famvt15%2Ffdc633
 */
public interface CustomerDao extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

    // 最好都返回List<T>或Optional<List<T>>，不返回T，因为不确保查到的是唯一的
    public List<Customer> findByCustNameAndCustIndustry(String name, String industry);

    public Optional<List<Customer>> findByCustIndustry(String industry);

    @Query(value = "select * from cst_customer where cust_name = ?1 and cust_industry = ?2", nativeQuery = true)
    public List<Customer> nativeFindByCustNameAndCustIndustry(String name, String industry);

    @Query(value = "update Customer set custName = ?2 where custId = ?1")
    @Modifying
    public void updateCustomer(long id, String name);
}
