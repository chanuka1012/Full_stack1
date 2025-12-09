package com.example.demo_Full_Stack_Project.fullstack.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo_Full_Stack_Project.fullstack.model.Payment;

public interface PaymentRepo extends MongoRepository<Payment, String>{

    Optional<Payment> findByPaymentId(String paymentId);
    List<Payment> findByStudentId(String studentId);
    List<Payment> findByStatus(String status);
    List<Payment> findByMonth(String month);

}
