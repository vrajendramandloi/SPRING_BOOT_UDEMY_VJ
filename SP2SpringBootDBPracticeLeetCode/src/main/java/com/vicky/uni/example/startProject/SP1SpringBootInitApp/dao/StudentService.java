package com.vicky.uni.example.startProject.SP1SpringBootInitApp.dao;

import com.vicky.uni.example.startProject.SP1SpringBootInitApp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRespository studentRespository;

    public List<Student> fetchAll() {
        return studentRespository.findAll();
    }
    public Optional<Student> getStudent(Integer id) {
        return studentRespository.findById(id);
    }
    public void deleteStudent(Integer id) {
        studentRespository.deleteById(id);
    }
    public void createStudent(Student student) {
        studentRespository.save(student);
    }
}
