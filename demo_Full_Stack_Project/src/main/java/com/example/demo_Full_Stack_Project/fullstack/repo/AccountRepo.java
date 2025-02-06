package com.example.demo_Full_Stack_Project.fullstack.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_Full_Stack_Project.fullstack.model.Account;

@Repository
public interface AccountRepo  extends MongoRepository<Account, String>{
    List<Account> findByUserId(String userId); // Find all accounts for a specific user

}
