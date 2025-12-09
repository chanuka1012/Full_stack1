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

import com.example.demo_Full_Stack_Project.fullstack.model.Payment;
import com.example.demo_Full_Stack_Project.fullstack.service.PaymentService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/payments")

public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment createdPayment = paymentService.createPayment(payment);
        return ResponseEntity.ok(createdPayment);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable String paymentId) {
        Payment payment = paymentService.getPaymentById(paymentId);
        if (payment != null) {
            return ResponseEntity.ok(payment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Payment>> getPaymentsByStudentId(@PathVariable String studentId) {
        List<Payment> payments = paymentService.getPaymentsByStudentId(studentId);
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Payment>> getPaymentsByStatus(@PathVariable String status) {
        List<Payment> payments = paymentService.getPaymentsByStatus(status);
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/month/{month}")
    public ResponseEntity<List<Payment>> getPaymentsByMonth(@PathVariable String month) {
        List<Payment> payments = paymentService.getPaymentsByMonth(month);
        return ResponseEntity.ok(payments);
    }

    @PutMapping("/update")
    public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment) {
        Payment updatedPayment = paymentService.updatePayment(payment);
        return ResponseEntity.ok(updatedPayment);
    }

    @DeleteMapping("/delete/{paymentId}")
    public ResponseEntity<Boolean> deletePayment(@PathVariable String paymentId) {
        boolean isDeleted = paymentService.deletePayment(paymentId);
        if (isDeleted) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

   

}
