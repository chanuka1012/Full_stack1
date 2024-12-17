package com.example.demo_Full_Stack_Project.fullstack.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo_Full_Stack_Project.fullstack.model.User;

public interface UserRepo extends MongoRepository<User ,String>{

    User findByEmail(String email);

}
