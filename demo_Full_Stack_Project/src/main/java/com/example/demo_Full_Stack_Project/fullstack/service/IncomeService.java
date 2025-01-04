package com.example.demo_Full_Stack_Project.fullstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo_Full_Stack_Project.fullstack.model.Income;
import com.example.demo_Full_Stack_Project.fullstack.repo.IncomeRepo;

@Service
@Transactional

public class IncomeService {

    @Autowired
    private IncomeRepo incomeRepo;

    public Income saveIncome(Income income){
        return incomeRepo.save(income);
    }

    public List<Income> getAllIncomes(){
        return incomeRepo.findAll();
    }

    public Income updateIncomeById(String id, Income income) {
        if (incomeRepo.existsById(id)) {
            income.setId(id); // Ensure the correct ID is set
            return incomeRepo.save(income);
        } else {
            return null; // Return null if income doesn't exist
        }
    }
    

    public boolean deleteIncomeById(String id){
        if(incomeRepo.existsById(id)){
            incomeRepo.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

}
