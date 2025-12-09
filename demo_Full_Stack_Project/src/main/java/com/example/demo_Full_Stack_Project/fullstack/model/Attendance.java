package com.example.demo_Full_Stack_Project.fullstack.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Attendances")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Attendance {

    @Id
    private String attendanceId;
    private String studentId;
    private String studentName;
    private LocalDate date;
    private String status; // "present", "absent"
    private String className;

}
