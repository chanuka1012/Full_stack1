package com.example.demo_Full_Stack_Project.fullstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo_Full_Stack_Project.fullstack.model.Category;

import com.example.demo_Full_Stack_Project.fullstack.repo.CategoryRepo;

@Service
@Transactional

public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo; 

    public Category SaveCategory(Category category) {
        
        return categoryRepo.save(category);
    }

    public List<Category> getAllCategories(){
		return categoryRepo.findAll();
	}

    public Category updateCategory(Category category){
        return categoryRepo.save(category);
    }

    

    public boolean deleteCategory(Category category) {
        try {
            categoryRepo.delete(category);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
