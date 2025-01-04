package com.example.demo_Full_Stack_Project.fullstack.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo_Full_Stack_Project.fullstack.model.Budget;

public interface BudgetRepo extends MongoRepository< Budget , String>{
       List<Budget> findByUserId(String userId);
}
