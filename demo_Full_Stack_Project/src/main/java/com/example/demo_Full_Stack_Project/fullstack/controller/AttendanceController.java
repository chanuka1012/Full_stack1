package com.example.demo_Full_Stack_Project.fullstack.controller;

import java.time.LocalDate;
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

import com.example.demo_Full_Stack_Project.fullstack.model.Attendance;
import com.example.demo_Full_Stack_Project.fullstack.service.AttendanceService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/attendances")

public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/mark")
    public ResponseEntity<Attendance> markAttendance(@RequestBody Attendance attendance) {
        Attendance markedAttendance = attendanceService.markAttendance(attendance);
        return ResponseEntity.ok(markedAttendance);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Attendance>> getAllAttendances() {
        List<Attendance> attendances = attendanceService.getAllAttendances();
        return ResponseEntity.ok(attendances);
    }

    @GetMapping("/{attendanceId}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable String attendanceId) {
        Attendance attendance = attendanceService.getAttendanceById(attendanceId);
        if (attendance != null) {
            return ResponseEntity.ok(attendance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Attendance>> getAttendancesByStudentId(@PathVariable String studentId) {
        List<Attendance> attendances = attendanceService.getAttendancesByStudentId(studentId);
        return ResponseEntity.ok(attendances);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Attendance>> getAttendancesByDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        List<Attendance> attendances = attendanceService.getAttendancesByDate(localDate);
        return ResponseEntity.ok(attendances);
    }

    @GetMapping("/class/{className}")
    public ResponseEntity<List<Attendance>> getAttendancesByClassName(@PathVariable String className) {
        List<Attendance> attendances = attendanceService.getAttendancesByClassName(className);
        return ResponseEntity.ok(attendances);
    }

    @GetMapping("/student/{studentId}/date/{date}")
    public ResponseEntity<Attendance> getAttendanceByStudentAndDate(
            @PathVariable String studentId, 
            @PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        Attendance attendance = attendanceService.getAttendanceByStudentAndDate(studentId, localDate);
        if (attendance != null) {
            return ResponseEntity.ok(attendance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Attendance> updateAttendance(@RequestBody Attendance attendance) {
        Attendance updatedAttendance = attendanceService.updateAttendance(attendance);
        return ResponseEntity.ok(updatedAttendance);
    }

    @DeleteMapping("/delete/{attendanceId}")
    public ResponseEntity<Boolean> deleteAttendance(@PathVariable String attendanceId) {
        boolean isDeleted = attendanceService.deleteAttendance(attendanceId);
        if (isDeleted) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
