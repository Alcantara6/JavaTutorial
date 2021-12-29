package com.yanjing.mapper;

import com.yanjing.pojo.Student;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @author yanjing
 * @date 2021/8/22
 */
public class StudentMapperImpl2 extends SqlSessionDaoSupport implements StudentMapper {

    @Override
    public List<Student> selectStudents() {

        return getSqlSession().getMapper(StudentMapper.class).selectStudents();
    }

    @Override
    public void update() {

    }

    @Override
    public int addStudent(Student student) {
        return 0;
    }

    @Override
    public int deleteStudent(int id) {
        return 0;
    }

}
