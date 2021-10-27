package com.yanjing.controllers;

import com.yanjing.models.Student;
import com.yanjing.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(value = "/students/{id}")
    public Student getStudentById(@PathVariable("id") @Min((1)) Integer id) {
        Student std = studentService.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with" + id + "is Not Found!"));
        return std;
    }

    @GetMapping(value = "/student")
    public Student getStudentByEmail(@Valid @RequestParam("email") String email) {
        Student std = studentService.findByEmail(email).orElseThrow(() -> new StudentNotFoundException("Student with email" + email + "is Not Found!"));
        return std;
    }

    @PostMapping(value = "/students")
    public Student addStudent(@Valid @RequestBody Student std) {
        return studentService.save(std);
    }

    @PutMapping(value = "/students/{id}")
    public Student updateStudent(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Student newstd) {
        Student stdu = studentService.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with" + id + "is Not Found!"));
        stdu.setFirstname(newstd.getFirstname());
        stdu.setLastname(newstd.getLastname());
        stdu.setEmail(newstd.getEmail());
        stdu.setGender(newstd.getGender());
        return studentService.save(stdu);
    }

    @DeleteMapping(value = "/students/{id}")
    public String deleteStudent(@PathVariable @Min(1) int id) {
        Student std = studentService.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with" + id + "is Not Found!"));
        studentService.deleteById(std.getId());
        return "Student with ID: " + id + "is deleted";
    }
}
