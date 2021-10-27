package com.yanjing.mapper;

import com.yanjing.pojo.Student;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * @author yanjing
 * @date 2021/8/22
 */
public class StudentMapperImpl implements StudentMapper {

    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Student> selectStudent() {

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        return mapper.selectStudent();
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
