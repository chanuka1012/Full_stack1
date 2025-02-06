package com.example.demo_Full_Stack_Project.fullstack.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_Full_Stack_Project.fullstack.model.Expense;


@Repository
public interface ExpenseRepo extends MongoRepository<Expense ,String>{

    List<Expense> findByUserId(String userId);
                             
}
