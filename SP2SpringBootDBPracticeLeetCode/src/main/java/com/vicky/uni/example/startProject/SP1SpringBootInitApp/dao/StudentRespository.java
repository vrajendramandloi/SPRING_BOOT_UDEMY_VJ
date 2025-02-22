package com.vicky.uni.example.startProject.SP1SpringBootInitApp.dao;

import com.vicky.uni.example.startProject.SP1SpringBootInitApp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRespository extends JpaRepository<Student, Integer> {
}
