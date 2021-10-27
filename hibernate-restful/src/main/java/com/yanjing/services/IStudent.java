package com.yanjing.services;

import com.yanjing.models.Student;

import java.util.List;
import java.util.Optional;

public interface IStudent {
    List<Student> getAllStudents();

    Optional<Student> findById(int id);

    Optional<Student> findByEmail(String email);

    Student save(Student std);

    void deleteById(int id);
}
