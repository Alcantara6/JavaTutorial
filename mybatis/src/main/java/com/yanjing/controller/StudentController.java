package com.yanjing.controller;

import com.yanjing.entity.Student;
import com.yanjing.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yanjing
 * @date 2021/6/20 - 下午11:13
 */
@RestController
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/queryStudents")
    public List<Student> queryStudents() {

        List<Student> students = studentMapper.queryStudents();
        return students;
    }

    @GetMapping("/queryStudentById/{id}")
    public Student queryStudentById(@PathVariable Integer id) {

        Student student = studentMapper.queryStudentById(id);
        return student;
    }
}
