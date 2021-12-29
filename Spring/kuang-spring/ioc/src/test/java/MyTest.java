import com.yanjing.pojo.Hello;
import com.yanjing.pojo.Student;
import com.yanjing.pojo.User;
import com.yanjing.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author yanjing
 * @date 2021/8/4
 */
public class MyTest {

    public static void main(String[] args) {

        // 获取Spring上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.getName());

        UserService userService = (UserService) context.getBean("userServiceImpl");
        System.out.println(userService.getUser());

        User u1 = context.getBean("u1", User.class);
        System.out.println(u1.getName());

        // No qualifying bean of type 'com.yanjing.pojo.User' available:
        // expected single matching bean but found 6: user1,user2,user3,user4,user5,user6
        // User user = context.getBean(User.class);
        // System.out.println(user.getName());

        User vipUser = (User) context.getBean("vipUser");
        System.out.println(vipUser.getName());

        Student student = (Student) context.getBean("student");
        student.show();
    }

    @Test
    void scopeTest() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        User singletonUser1 = context.getBean("user1", User.class);
        User singletonUser2 = context.getBean("user1", User.class);

        User prototypeUser1 = context.getBean("user6", User.class);
        User prototypeUser2 = context.getBean("user6", User.class);


        assertTrue(singletonUser1 == singletonUser2);
        assertFalse(prototypeUser1 == prototypeUser2);
    }
}
