package com.yanjing.mapper;

import com.yanjing.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yanjing
 * @date 2021/6/20 - 下午8:ache29
 */
@Mapper
@Repository
public interface StudentMapper {

    List<Student> queryStudents();

    Student queryStudentById(int id);

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Student student);
}
