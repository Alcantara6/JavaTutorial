package com.yanjing.mapper;

import com.yanjing.pojo.Student;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @author yanjing
 * @date 2021/8/22
 */
public class TxStudentMapperImpl extends SqlSessionDaoSupport implements StudentMapper {
    @Override
    public List<Student> selectStudents() {

        StudentMapper mapper = getSqlSession().getMapper(StudentMapper.class);
        return mapper.selectStudents();
    }

    @Override
    public void update() {

        Student student = new Student();
        student.setId(5);
        student.setFirstname("wei");
        student.setLastname("xiaobao");
        student.setEmail("abc@123.com");
        addStudent(student);
        deleteStudent(5);
        List<Student> students = selectStudents();
        for (Student s : students) {
            System.out.println(s);
        }
    }

    @Override
    public int addStudent(Student student) {


        return getSqlSession().getMapper(StudentMapper.class).addStudent(student);
    }

    @Override
    public int deleteStudent(int id) {

        return getSqlSession().getMapper(StudentMapper.class).deleteStudent(id);
    }
}
