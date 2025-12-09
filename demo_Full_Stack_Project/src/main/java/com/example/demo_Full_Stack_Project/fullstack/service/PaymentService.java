package com.example.demo_Full_Stack_Project.fullstack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo_Full_Stack_Project.fullstack.model.Payment;
import com.example.demo_Full_Stack_Project.fullstack.model.Student;
import com.example.demo_Full_Stack_Project.fullstack.repo.PaymentRepo;
import com.example.demo_Full_Stack_Project.fullstack.repo.StudentRepo;


@Service
@Transactional

public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private StudentRepo studentRepo;

    
    public Payment createPayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    // public Payment createPayment(Payment payment) {
    //     Payment savedPayment = paymentRepo.save(payment);
        
    //     // Send SMS if payment status is "paid"
    //     if ("paid".equalsIgnoreCase(savedPayment.getStatus())) {
    //         sendPaymentSms(savedPayment);
    //     }
        
    //     return savedPayment;
    // }

    // private void sendPaymentSms(Payment payment) {
    //     try {
    //         // Get student details including mobile number
    //         Optional<Student> studentOpt = studentRepo.findByStudentId(payment.getStudentId());
            
    //         if (studentOpt.isPresent()) {
    //             Student student = studentOpt.get();
    //             String mobileNumber = student.getMobileNumber();
                
    //             // Validate mobile number format
    //             if (mobileNumber != null && !mobileNumber.trim().isEmpty()) {
    //                 // Format mobile number (add +91 for India, or +1 for US, etc.)
    //                 String formattedNumber = formatPhoneNumber(mobileNumber);
                    
    //                 // Send SMS
    //                 smsService.sendPaymentConfirmationSms(
    //                     formattedNumber,
    //                     student.getStudentName(),
    //                     String.valueOf(payment.getAmount()),
    //                     payment.getMonth(),
    //                     payment.getReceiptNumber()
    //                 );
                    
    //                 // Optionally create notification record
    //                 createPaymentNotification(payment, student);
                    
    //             } else {
    //                 System.out.println("No mobile number found for student: " + student.getStudentId());
    //             }
    //         }
    //     } catch (Exception e) {
    //         System.err.println("Error sending payment SMS: " + e.getMessage());
    //         // Don't throw exception - SMS failure shouldn't prevent payment recording
    //     }
    // }

    private String formatPhoneNumber(String phoneNumber) {
        // Remove any non-digit characters
        String digits = phoneNumber.replaceAll("\\D", "");
        
        // Add country code if needed
        if (digits.startsWith("0")) {
            digits = digits.substring(1);
        }
        
        // Add country code for India (modify for your country)
        if (digits.length() == 10) {
            return "+91" + digits;
        }
        
        // If already has country code, just add +
        if (!digits.startsWith("+")) {
            return "+" + digits;
        }
        
        return digits;
    }
    
    private void createPaymentNotification(Payment payment, Student student) {
        // Optional: Create notification record in database
        // You can use your existing NotificationService here
    }

    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

    public Payment getPaymentById(String paymentId) {
        Optional<Payment> payment = paymentRepo.findByPaymentId(paymentId);
        return payment.orElse(null);
    }

    public List<Payment> getPaymentsByStudentId(String studentId) {
        return paymentRepo.findByStudentId(studentId);
    }

    public List<Payment> getPaymentsByStatus(String status) {
        return paymentRepo.findByStatus(status);
    }

    public List<Payment> getPaymentsByMonth(String month) {
        return paymentRepo.findByMonth(month);
    }

    public Payment updatePayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    public boolean deletePayment(String paymentId) {
        Optional<Payment> payment = paymentRepo.findByPaymentId(paymentId);
        if (payment.isPresent()) {
            paymentRepo.delete(payment.get());
            return true;
        }
        return false;
    }

}
