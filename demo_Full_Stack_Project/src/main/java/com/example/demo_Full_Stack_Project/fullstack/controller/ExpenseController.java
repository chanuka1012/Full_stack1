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

import com.example.demo_Full_Stack_Project.fullstack.model.Expense;
import com.example.demo_Full_Stack_Project.fullstack.model.Income;
import com.example.demo_Full_Stack_Project.fullstack.service.ExpenseService;


@RestController
@RequestMapping("api/expenses")
@CrossOrigin(origins = "http://localhost:5173") // Allow requests from React app

public class ExpenseController {

    @Autowired
     private ExpenseService expenseService;
  
     @GetMapping("/all")
     public ResponseEntity<List<Expense>> getAllExpenses(){
        
         List<Expense> expenses = expenseService.getAllExpenses();
         return ResponseEntity.ok(expenses);
     }

     @GetMapping("/{userId}")
public ResponseEntity<List<Expense>> getExpensesByUserId(@PathVariable String userId) {
    List<Expense> expenses = expenseService.getExpensesByUserId(userId);
    return ResponseEntity.ok(expenses);
}

       
    
     @PostMapping("/save")
     public ResponseEntity<Expense> save(@RequestBody Expense expense){
        
         Expense SavedExpense = expenseService.SaveExpense(expense);
         return ResponseEntity.ok(SavedExpense);
     }


    @PutMapping("/updateExpense/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable String id, @RequestBody Expense expense) {
       Expense updatedExpense = expenseService.updateExpenseById(id,  expense);
       if (updatedExpense != null) {
          return ResponseEntity.ok(updatedExpense);
       } else {
          return ResponseEntity.status(404).body(null); // Return 404 if income not found
       }
    } 


    @DeleteMapping("/deleteExpense/{id}")
public ResponseEntity<String> deleteExpense(@PathVariable String id) {
    boolean isDeleted = expenseService.deleteExpenseById(id);
    if (isDeleted) {
        return ResponseEntity.ok("Expense deleted successfully");
    } else {
        return ResponseEntity.status(404).body("Expense not found");
    }
}


}
