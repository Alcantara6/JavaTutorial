package cn.itcast.dao;

import cn.itcast.domain.LinkMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author yanjing
 * @date 2022/3/19
 */
public interface LinkmanDao extends JpaRepository<LinkMan, Long>, JpaSpecificationExecutor<LinkMan> {
}
