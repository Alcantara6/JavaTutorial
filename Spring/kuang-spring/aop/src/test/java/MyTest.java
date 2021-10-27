import com.yanjing.service.UserService;
import com.yanjing.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yanjing
 * @date 2021/8/20
 */
public class MyTest {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 动态代理的是接口
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();

        // 第二种方式
        UserService userService2 = context.getBean("userService2", UserService.class);
        userService2.add();

        // 第三种注解方式
        UserService userService3 = context.getBean("userService3", UserService.class);
        userService3.add();
    }
}
