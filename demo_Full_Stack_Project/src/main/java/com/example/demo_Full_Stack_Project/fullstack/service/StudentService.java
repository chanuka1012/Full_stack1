package com.example.demo_Full_Stack_Project.fullstack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo_Full_Stack_Project.fullstack.model.Student;
import com.example.demo_Full_Stack_Project.fullstack.repo.StudentRepo;

@Service
@Transactional

public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public Student RegisterStudent(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    public Student updateStudent(Student student){
        return studentRepo.save(student);
    }

    public Student updateStudentById(String studentId, Student studentDetails) {
        Optional<Student> optionalStudent = studentRepo.findByStudentId(studentId);
        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            
            // Update the fields
            existingStudent.setStudentName(studentDetails.getStudentName());
            existingStudent.setEmail(studentDetails.getEmail());
            existingStudent.setSchool(studentDetails.getSchool());
            existingStudent.setClassName(studentDetails.getClassName());
            existingStudent.setMobileNumber(studentDetails.getMobileNumber());
            
            return studentRepo.save(existingStudent);
        }
        return null; // Student not found
    }

    public boolean deleteStudent(Student student) {
        try {
            studentRepo.delete(student);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteStudentById(String studentId) {
        Optional<Student> student = studentRepo.findByStudentId(studentId);
        if (student.isPresent()) {
            studentRepo.delete(student.get());
            return true;
        }
        return false;
    }

    public Student getStudentById(String studentId) {
        Optional<Student> student = studentRepo.findByStudentId(studentId);
        return student.orElse(null); // Returns null if student not found
    }

    public Student getStudentByClassName(String className) {
        Optional<Student> student = studentRepo.findByClassName(className);
        return student.orElse(null); // Returns null if student not found
    }
}


