package com.example.demo_Full_Stack_Project.fullstack.service;

import java.util.List;

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

    public Expense updateExpense(Expense expense){
        return expenseRepo.save(expense);
    }

    

    public boolean deleteExpenseById(String id) {
        if (expenseRepo.existsById(id)) {
            expenseRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    
}
