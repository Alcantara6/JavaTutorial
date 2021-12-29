import com.yanjing.mapper.StudentMapper;
import com.yanjing.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author yanjing
 * @date 2021/8/22
 */
public class MyTest {

    @Test
    public void test() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper mapper = context.getBean("studentMapper", StudentMapper.class);
        List<Student> students = mapper.selectStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void test2() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper mapper = context.getBean("studentMapper2", StudentMapper.class);
        List<Student> students = mapper.selectStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void test3() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper mapper = context.getBean("txStudentMapper", StudentMapper.class);
        mapper.update();
    }
}
