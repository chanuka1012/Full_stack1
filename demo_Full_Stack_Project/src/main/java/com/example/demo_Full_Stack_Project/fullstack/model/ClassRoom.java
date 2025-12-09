package com.example.demo_Full_Stack_Project.fullstack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "ClassRooms")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClassRoom {

    @Id
    private String classId;
    private String className; // "Grade 1", "Grade 2", etc.
    private String classTeacherId;
    private String classTeacherName;
    private Double monthlyFee;
    private String schedule; // "Mon-Wed-Fri 4-6PM"
    private String academicYear;

}
