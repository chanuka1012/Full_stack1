package com.example.demo_Full_Stack_Project.fullstack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Students")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {

    @Id
    private String studentId;
    private String studentName;
    private String email;
    private String school;
    private String className;
    private String mobileNumber;

}


