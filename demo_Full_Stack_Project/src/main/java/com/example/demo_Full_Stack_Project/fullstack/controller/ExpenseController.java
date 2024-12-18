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

import com.example.demo_Full_Stack_Project.fullstack.model.Expense;

import com.example.demo_Full_Stack_Project.fullstack.service.ExpenseService;


@RestController
@RequestMapping("api/expenses")

public class ExpenseController {

    @Autowired
     private ExpenseService expenseService;
  
     @GetMapping("/all")
     public ResponseEntity<List<Expense>> getAllExpenses(){
        
         List<Expense> expenses = expenseService.getAllExpenses();
         return ResponseEntity.ok(expenses);
     }
       
    
     @PostMapping("/save")
     public ResponseEntity<Expense> save(@RequestBody Expense expense){
         Expense SavedExpense = expenseService.SaveExpense(expense);
         return ResponseEntity.ok(SavedExpense);
     }


    @PutMapping("/updateExpense")
    public ResponseEntity<Expense> updateExpense(@RequestBody Expense expense){
        Expense UpdatedUser = expenseService.updateExpense(expense);
        return ResponseEntity.ok(UpdatedUser);
    }

    @DeleteMapping("/deleteExpense")
    public boolean deleteExpense(@RequestBody Expense expense){
        return expenseService.deleteExpense(expense);
    }

}
