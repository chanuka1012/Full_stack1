package com.example.demo_Full_Stack_Project.fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_Full_Stack_Project.fullstack.model.Budget;
import com.example.demo_Full_Stack_Project.fullstack.service.BudgetService;

@RestController
@RequestMapping("api/budgets")
@CrossOrigin(origins = "http://localhost:5173") // Allow requests from React app

public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @GetMapping("/all")
    public ResponseEntity<List<Budget>> getAllBudgets(){
        List<Budget> budgets=budgetService.getAllBudgets();
        return ResponseEntity.ok(budgets);
    }

    @PostMapping("/save")
    public ResponseEntity<Budget> save(@RequestBody Budget budget){
        Budget savedBudget = budgetService.saveBudget(budget);
        return ResponseEntity.ok(savedBudget);
    }

    @PutMapping("/updateBudget/{id}")
    public ResponseEntity<Budget> updateBudget(@PathVariable String id, @RequestBody Budget budget){
        Budget updateBudget = budgetService.updateBudgetById(id, budget);
        if(updateBudget != null){
            return ResponseEntity.ok(updateBudget);
        }else{
            return ResponseEntity.status(404).body(null);//budget not found
        }
    }

    @DeleteMapping("/deleteBudget/{id}")
    public ResponseEntity<String> deleteBudget(@PathVariable String id){
        boolean isDeleted = budgetService.deleteBudgetById(id);
        if(isDeleted){
            return ResponseEntity.ok("Budget deleted successfully");
        }else{
            return ResponseEntity.status(404).body("Budget nit found");
        }
    }

}
