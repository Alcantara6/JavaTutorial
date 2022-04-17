import com.yanjing.service.UserService;
import com.yanjing.service.sub.AopTargetService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yanjing
 * @date 2021/8/20
 */
public class MyTest {

    @Test
    void test1() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 动态代理的是接口，这里返回的是被创建的代理类，只能向上转型为UserService类型
        UserService userService = context.getBean("userService", UserService.class);
        userService.add(1, 2);
    }

    @Test
    void test2() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 第二种方式
        UserService userService2 = context.getBean("userService2", UserService.class);
        userService2.add(1, 2);
    }

    @Test
    void test3() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 第三种注解方式
        UserService userService3 = context.getBean("userService3", UserService.class);
        userService3.add(1, 2);
    }

    @Test
    void test4() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 第三种注解方式拓展
        AopTargetService aopTargetService = context.getBean("aopService", AopTargetService.class);
        aopTargetService.step();
        AopTargetService aopTargetService2 = context.getBean("aopService2", AopTargetService.class);
        aopTargetService2.runFast(1);
    }
}
