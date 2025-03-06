package com.example.demo_Full_Stack_Project.fullstack.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_Full_Stack_Project.fullstack.model.Report;
import com.example.demo_Full_Stack_Project.fullstack.service.ReportService;

@RestController
@RequestMapping("api/reports")
@CrossOrigin(origins = "http://localhost:5173")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/summary/{userId}/{startDate}/{endDate}")
    public ResponseEntity<Map<String, Object>> generateReport(@PathVariable String userId,
            @PathVariable String startDate, @PathVariable String endDate) {
        Map<String, Object> reportData = reportService.generateReportByCategory(userId, startDate, endDate);
        return ResponseEntity.ok(reportData);
    }
}
