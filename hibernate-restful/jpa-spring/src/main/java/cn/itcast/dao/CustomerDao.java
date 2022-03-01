package cn.itcast.dao;

import cn.itcast.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author yanjing
 * @date 2022/3/1
 */
public interface CustomerDao extends JpaRepository<Customer, Long>, JpaSpecificationExecutor {
}
