package com.example.demo_Full_Stack_Project.fullstack.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo_Full_Stack_Project.fullstack.model.Attendance;
import com.example.demo_Full_Stack_Project.fullstack.repo.AttendanceRepo;

@Service
@Transactional

public class AttendanceService {


    @Autowired
    private AttendanceRepo attendanceRepo;

    public Attendance markAttendance(Attendance attendance) {
        return attendanceRepo.save(attendance);
    }

    public List<Attendance> getAllAttendances() {
        return attendanceRepo.findAll();
    }

    public Attendance getAttendanceById(String attendanceId) {
        Optional<Attendance> attendance = attendanceRepo.findByAttendanceId(attendanceId);
        return attendance.orElse(null);
    }

    public List<Attendance> getAttendancesByStudentId(String studentId) {
        return attendanceRepo.findByStudentId(studentId);
    }

    public List<Attendance> getAttendancesByDate(LocalDate date) {
        return attendanceRepo.findByDate(date);
    }

    public List<Attendance> getAttendancesByClassName(String className) {
        return attendanceRepo.findByClassName(className);
    }

    public Attendance getAttendanceByStudentAndDate(String studentId, LocalDate date) {
        List<Attendance> attendances = attendanceRepo.findByStudentIdAndDate(studentId, date);
        return attendances.isEmpty() ? null : attendances.get(0);
    }

    public Attendance updateAttendance(Attendance attendance) {
        return attendanceRepo.save(attendance);
    }

    public boolean deleteAttendance(String attendanceId) {
        Optional<Attendance> attendance = attendanceRepo.findByAttendanceId(attendanceId);
        if (attendance.isPresent()) {
            attendanceRepo.delete(attendance.get());
            return true;
        }
        return false;
    }
}
