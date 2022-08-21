package repositories;

import com.yanjing.MySpringBootDataJpaApplication;
import com.yanjing.repositories.AuthorityRepository;
import com.yanjing.repositories.UserRepository;
import com.yanjing.template.many2many.Authority;
import com.yanjing.template.many2many.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

/**
 * @author yanjing
 * @date 2022/3/22
 */
// 因为子模块Spring也配置了datasource，可能会冲突，所以外边项目无法启动和做集成测试
@SpringBootTest(classes = MySpringBootDataJpaApplication.class)
@Transactional
@Rollback
@Slf4j
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