package com.yanjing.repositories;

import com.yanjing.HibernateRestfulApplication;
import com.yanjing.template.many2many.Authority;
import com.yanjing.template.many2many.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;

/**
 * @author yanjing
 * @date 2022/3/22
 */
// 因为子模块Spring也配置了datasource，可能会冲突，所以外边项目无法启动和做集成测试
@SpringBootTest(classes = HibernateRestfulApplication.class)
@ActiveProfiles("test")
@Transactional
@Rollback
class ManyToManyTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Test
    public void createTest() {

        Authority authority = new Authority();
        authority.setName("管理员");

        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123");

        user.getAuthorities().add(authority);

        userRepository.save(user);
        authorityRepository.save(authority);
    }
}