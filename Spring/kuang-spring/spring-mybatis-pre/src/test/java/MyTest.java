import com.yanjing.mapper.StudentMapper;
import com.yanjing.pojo.Student;
import com.yanjing.util.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author yanjing
 * @date 2021/8/22
 */
public class MyTest {

    @Test
    public void test() throws IOException {

        SqlSession sqlSession = MybatisUtil.getSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectStudent();

        for (Student student : students) {
            System.out.println(student);
        }

        sqlSession.close();
    }
}
