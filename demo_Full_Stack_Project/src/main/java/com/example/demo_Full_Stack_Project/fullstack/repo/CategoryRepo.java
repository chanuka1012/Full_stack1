package com.example.demo_Full_Stack_Project.fullstack.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo_Full_Stack_Project.fullstack.model.Category;


public interface CategoryRepo extends MongoRepository<Category ,String> {

}
