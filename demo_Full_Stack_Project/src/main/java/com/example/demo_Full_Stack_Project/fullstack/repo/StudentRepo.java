package com.example.demo_Full_Stack_Project.fullstack.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo_Full_Stack_Project.fullstack.model.Student;

public interface StudentRepo extends MongoRepository<Student ,String>{
    Student findByEmail(String email);
    Optional<Student> findByStudentId(String studentId);
    Optional<Student> findByClassName(String className);
}



