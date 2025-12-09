package com.example.demo_Full_Stack_Project.fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_Full_Stack_Project.fullstack.model.Student;
import com.example.demo_Full_Stack_Project.fullstack.service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // Allow requests from React app
@RequestMapping("api/students")

public class StudentController {

    @Autowired
     private StudentService studentService;

     @GetMapping("/all")
     public ResponseEntity<List<Student>> getAllStudents(){
        
         List<Student> students = studentService.getAllStudents();
         return ResponseEntity.ok(students);
     }

     @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable String studentId){
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{className}")
    public ResponseEntity<Student> getStudentByClassName(@PathVariable String className){
        Student student = studentService.getStudentByClassName(className);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

     @PostMapping("/register")
     public ResponseEntity<Student> register(@RequestBody Student student){
         Student RegisteredStudent = studentService.RegisterStudent(student);
         return ResponseEntity.ok(RegisteredStudent);
     }

     @PutMapping("/updateStudent")
     public ResponseEntity<Student> updateStudent(@RequestBody Student student){
         Student UpdatedStudent = studentService.updateStudent(student);
         return ResponseEntity.ok(UpdatedStudent);
     }

     @PutMapping("/update/{studentId}")
    public ResponseEntity<Student> updateStudentById(@PathVariable String studentId, @RequestBody Student student){
        Student updatedStudent = studentService.updateStudentById(studentId, student);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

     @DeleteMapping("/deleteStudent")
     public boolean deleteStudent(@RequestBody Student student){
         return studentService.deleteStudent(student);
     }

     @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<Boolean> deleteStudentById(@PathVariable String studentId){
        boolean isDeleted = studentService.deleteStudentById(studentId);
        if (isDeleted) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
