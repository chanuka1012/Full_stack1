package com.example.demo_Full_Stack_Project.fullstack.controller;

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

    @GetMapping("/{userId}")
    public ResponseEntity<Report> getReport(@PathVariable String userId) {
        Report report = reportService.generateReport(userId);
        return ResponseEntity.ok(report);
    }

}
