package com.example.demo_Full_Stack_Project.fullstack.repo;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo_Full_Stack_Project.fullstack.model.Income;

public interface IncomeRepo extends MongoRepository<Income, String>{

    List<Income> findByUserId(String userId);

}
