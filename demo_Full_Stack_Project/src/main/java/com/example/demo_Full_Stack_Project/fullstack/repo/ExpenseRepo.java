package com.example.demo_Full_Stack_Project.fullstack.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_Full_Stack_Project.fullstack.model.Expense;


@Repository
public interface ExpenseRepo extends MongoRepository<Expense ,String>{

}