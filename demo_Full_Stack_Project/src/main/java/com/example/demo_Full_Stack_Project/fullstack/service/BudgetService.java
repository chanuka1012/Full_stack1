package com.example.demo_Full_Stack_Project.fullstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo_Full_Stack_Project.fullstack.model.Budget;
import com.example.demo_Full_Stack_Project.fullstack.repo.BudgetRepo;

@Service
@Transactional

public class BudgetService {

    @Autowired
    private BudgetRepo budgetRepo;

    public Budget saveBudget(Budget budget){
        return budgetRepo.save(budget);
    }

    public List<Budget> getAllBudgets(){
        return budgetRepo.findAll();
    }

    public Budget updateBudgetById(String id , Budget budget){
        if(budgetRepo.existsById(id)){
            budget.setId(id);// ensure correct id is set
            return budgetRepo.save(budget);
        }else{
            return null;// return null if budget does not exist
        }
    }

    public boolean deleteBudgetById(String id){
        if(budgetRepo.existsById(id)){
            budgetRepo.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

}
