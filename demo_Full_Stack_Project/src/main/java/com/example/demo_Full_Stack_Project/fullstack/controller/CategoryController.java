package com.example.demo_Full_Stack_Project.fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_Full_Stack_Project.fullstack.model.Category;

import com.example.demo_Full_Stack_Project.fullstack.service.CategoryService;


@RestController
@RequestMapping("api/categories")

public class CategoryController {

    @Autowired
     private CategoryService categoryService;
  
     @GetMapping("/all")
     public ResponseEntity<List<Category>> getAllCategories(){
        
         List<Category> categories = categoryService.getAllCategories();
         return ResponseEntity.ok(categories);
     }
       
    
     @PostMapping("/save")
     public ResponseEntity<Category> save(@RequestBody  Category category){
         Category SavedCategory = categoryService.SaveCategory(category);
         return ResponseEntity.ok(SavedCategory);
     }


    @PutMapping("/updateCategory")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category){
        Category UpdatedCategory = categoryService.updateCategory(category);
        return ResponseEntity.ok(UpdatedCategory);
    }

    @DeleteMapping("/deleteCategory")
    public boolean deleteCategory(@RequestBody Category category){
        return categoryService.deleteCategory(category);
    }

}
