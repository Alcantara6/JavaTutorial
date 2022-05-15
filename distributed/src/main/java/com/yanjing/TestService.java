package com.yanjing;

import com.yanjing.persistence.mysql.entity.Student;
import com.yanjing.persistence.mysql.repository.StudentRepository;
import com.yanjing.persistence.pg.entity.Audit;
import com.yanjing.persistence.pg.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yanjing
 * @date 2022/5/15
 */
@Service
public class TestService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AuditRepository auditRepository;

    /**
     * tx1, tx的transaction都加入到当前
     * 当前用的是哪个事务，就作用于哪个的插入
     */
    @Transactional
    // @Transactional(transactionManager = "transactionManagerSecondary")
    public void tx() {
        tx1();
        tx2();
    }

    @Transactional(transactionManager = "transactionManagerPrimary")
    public void tx1() {

        Student student = new Student();
        student.setFirstname("jing2");
        student.setLastname("yan2");
        student.setGender(0);
        student.setEmail("yj2@home.com");

        studentRepository.save(student);
    }

    @Transactional(transactionManager = "transactionManagerSecondary")
    public void tx2() {

        Audit audit = new Audit();
        audit.setName("audit-name");

        auditRepository.save(audit);

        // int a = 1 / 0;
    }
}
