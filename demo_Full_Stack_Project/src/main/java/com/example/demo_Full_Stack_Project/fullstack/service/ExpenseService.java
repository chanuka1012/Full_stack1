package com.example.demo_Full_Stack_Project.fullstack.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo_Full_Stack_Project.fullstack.model.Expense;

import com.example.demo_Full_Stack_Project.fullstack.repo.ExpenseRepo;


@Service
@Transactional

public class ExpenseService {

    @Autowired
    private ExpenseRepo expenseRepo; 

    public Expense SaveExpense(Expense expense) {
        
        return expenseRepo.save(expense);
    }

    public List<Expense> getAllExpenses(){
		return expenseRepo.findAll();
	}

    
    

    //public List<Expense> generateExpenseReport(String userId, String startDate, String endDate) {
     //   return expenseRepo.findByUserIdAndDateBetween(userId, startDate, endDate);
    //}

    public Map<String, Double> generateExpenseReportByCategory(String userId, String startDate, String endDate) {
        List<Expense> expenses = expenseRepo.findByUserIdAndDateBetween(userId, startDate, endDate);
        
        // Aggregate expenses by category
        Map<String, Double> categoryExpenses = new HashMap<>();
        for (Expense expense : expenses) {
            categoryExpenses.put(expense.getCategory(), categoryExpenses.getOrDefault(expense.getCategory(), 0.0) + expense.getAmount());
        }
        return categoryExpenses;
    }
    

    public Expense updateExpenseById(String id, Expense expense) {
        if (expenseRepo.existsById(id)) {
            expense.setId(id); // Ensure the correct ID is set
            return expenseRepo.save(expense);
        } else {
            return null; // Return null if income doesn't exist
        }
    }
    

    public boolean deleteExpenseById(String id) {
        if (expenseRepo.existsById(id)) {
            expenseRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Expense> getExpensesByUserId(String userId) {
        return expenseRepo.findByUserId(userId);
    }
    

    
    
}
