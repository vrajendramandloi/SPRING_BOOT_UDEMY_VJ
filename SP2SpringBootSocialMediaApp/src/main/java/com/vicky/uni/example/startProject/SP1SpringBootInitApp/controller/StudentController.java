package com.vicky.uni.example.startProject.SP1SpringBootInitApp.controller;

import com.vicky.uni.example.startProject.SP1SpringBootInitApp.dao.StudentService;
import com.vicky.uni.example.startProject.SP1SpringBootInitApp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/getAllStudents")
    public List<Student> fetchAllStudent() {
        return studentService.fetchAll();
    }

    @GetMapping(path = "/getStudent/{id}")
    public Student fetchAllStudent(@PathVariable int id) {
        Optional<Student> student = studentService.getStudent(id);
        return student.orElse(null);
    }

    @DeleteMapping(path = "/deleteStudent/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

    @PostMapping(path = "/createStudent")
    public void createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
    }
}
