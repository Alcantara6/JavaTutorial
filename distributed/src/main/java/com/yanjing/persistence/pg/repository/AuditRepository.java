package com.yanjing.persistence.pg.repository;

import com.yanjing.persistence.pg.entity.Audit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yanjing
 * @date 2022/5/15
 */
@Repository
public interface AuditRepository extends CrudRepository<Audit, Long> {
}
