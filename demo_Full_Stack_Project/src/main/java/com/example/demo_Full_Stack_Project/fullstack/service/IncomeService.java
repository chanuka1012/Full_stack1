package com.example.demo_Full_Stack_Project.fullstack.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, Double> generateIncomeReportBySource(String userId, String startDate, String endDate) {
        List<Income> incomes = incomeRepo.findByUserIdAndDateBetween(userId, startDate, endDate);

        // Aggregate income by source
        Map<String, Double> sourceIncome = new HashMap<>();
        for (Income income : incomes) {
            sourceIncome.put(income.getSource(), sourceIncome.getOrDefault(income.getSource(), 0.0) + income.getAmount());
        }
        return sourceIncome;
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
