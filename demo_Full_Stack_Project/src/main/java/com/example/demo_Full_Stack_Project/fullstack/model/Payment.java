package com.example.demo_Full_Stack_Project.fullstack.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Payments")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Payment {
    @Id
    private String paymentId;
    private String studentId;
    private String studentName;
    private String month; // e.g., "January 2024", "February 2024"
    private Double amount;
    private LocalDate paymentDate;
    private String paymentMethod; // "cash", "card"
    private String status; // "paid", "unpaid"
    private String receiptNumber;
}
