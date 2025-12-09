package com.example.demo_Full_Stack_Project.fullstack.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo_Full_Stack_Project.fullstack.model.Attendance;

public interface AttendanceRepo extends MongoRepository<Attendance, String>{

    Optional<Attendance> findByAttendanceId(String attendanceId);
    List<Attendance> findByStudentId(String studentId);
    List<Attendance> findByDate(LocalDate date);
    List<Attendance> findByClassName(String className);
    List<Attendance> findByStudentIdAndDate(String studentId, LocalDate date);

}
