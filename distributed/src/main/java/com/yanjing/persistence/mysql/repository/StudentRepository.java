package com.yanjing.persistence.mysql.repository;

import com.yanjing.persistence.mysql.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yanjing
 * @date 2022/5/15
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
}
