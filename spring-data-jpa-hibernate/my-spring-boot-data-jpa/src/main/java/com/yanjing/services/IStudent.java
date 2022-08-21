package com.yanjing.services;

import com.yanjing.models.Student;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IStudent {
    List<Student> getAllStudents();

    Optional<Student> findById(int id);

    Optional<Student> findByEmail(String email);

    Student save(Student std);

    void deleteById(int id);

    Page<Student> getPagedStudents();

    long countByEmail(String email);
}
