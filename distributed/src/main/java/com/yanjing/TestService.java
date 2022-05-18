package com.yanjing;

import com.yanjing.persistence.mysql.entity.Student;
import com.yanjing.persistence.mysql.repository.StudentRepository;
import com.yanjing.persistence.pg.entity.Audit;
import com.yanjing.persistence.pg.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

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

    @Autowired
    @Qualifier("transactionManagerPrimary")
    private PlatformTransactionManager transactionManagerPrimary;

    @Autowired
    @Qualifier("transactionManagerSecondary")
    private PlatformTransactionManager transactionManagerSecondary;

    @Autowired
    @Qualifier("chainedTransactionManager")
    PlatformTransactionManager transactionManager;

    /**
     * tx1, tx的transaction都加入到当前
     * 当前用的是哪个事务，就作用于哪个的插入
     */
    @Transactional
    // @Transactional(transactionManager = "transactionManagerSecondary")
    public boolean tx() {
        tx1();
        tx2("audit-name");
        tx2(null); // 传null，使第二次插入出错，验证两个事务是否都回滚
        return true;
    }

    @Transactional(transactionManager = "chainedTransactionManager")
    public boolean chained() {
        tx1();
        tx2("audit-name");
        tx2(null);
        return true;
    }

    public boolean programmatic() {

        TransactionStatus primaryStatus = transactionManagerPrimary.getTransaction(new DefaultTransactionDefinition());
        TransactionStatus secondaryStatus = transactionManagerSecondary.getTransaction(new DefaultTransactionDefinition());
        try {
            tx1();
            tx2("audit-name");
            tx2(null);
            transactionManagerSecondary.commit(secondaryStatus);
            transactionManagerPrimary.commit(primaryStatus);
            return true;
        } catch (Exception e) {
            transactionManagerSecondary.rollback(secondaryStatus);
            transactionManagerPrimary.rollback(primaryStatus);
            return false;
        }
    }

    // @Transactional(transactionManager = "transactionManagerPrimary")
    public void tx1() {

        Student student = new Student();
        student.setFirstname("jing2");
        student.setLastname("yan2");
        student.setGender(0);
        student.setEmail("yj2@home.com");

        studentRepository.save(student);
    }

    // @Transactional(transactionManager = "transactionManagerSecondary")
    public void tx2(String name) {

        Audit audit = new Audit();
        audit.setName(name);

        auditRepository.save(audit);
    }
}
