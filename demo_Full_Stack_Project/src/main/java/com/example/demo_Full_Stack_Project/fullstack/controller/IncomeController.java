package com.example.demo_Full_Stack_Project.fullstack.controller;

import java.util.List;
import java.util.Map;

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
import com.example.demo_Full_Stack_Project.fullstack.service.IncomeService;

@RestController
@RequestMapping("api/incomes")
@CrossOrigin(origins="http://localhost:5173")// Allow requests from React app

public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @GetMapping("/all")
    public ResponseEntity<List<Income>> getAllIncomes(){
        List<Income> incomes=incomeService.getAllIncomes();
        return ResponseEntity.ok(incomes);
    }

    @GetMapping("/report/source/{userId}/{startDate}/{endDate}")
    public ResponseEntity<Map<String, Double>> generateIncomeReportBySource(@PathVariable String userId,
            @PathVariable String startDate, @PathVariable String endDate) {
        Map<String, Double> sourceIncome = incomeService.generateIncomeReportBySource(userId, startDate, endDate);
        return ResponseEntity.ok(sourceIncome);
    }


    @PostMapping("/save")
    public ResponseEntity<Income>save(@RequestBody Income income){
        Income savedIncome = incomeService.saveIncome(income);
        return ResponseEntity.ok(savedIncome);
    }

    @PutMapping("/updateIncome/{id}")
    public ResponseEntity<Income> updateIncome(@PathVariable String id, @RequestBody Income income) {
       Income updatedIncome = incomeService.updateIncomeById(id, income);
       if (updatedIncome != null) {
          return ResponseEntity.ok(updatedIncome);
       } else {
          return ResponseEntity.status(404).body(null); // Return 404 if income not found
       }
    } 


    @DeleteMapping("/deleteIncome/{id}")
    public ResponseEntity<String> deleteIncome(@PathVariable String id){
        boolean isDeleted = incomeService.deleteIncomeById(id);
        if(isDeleted){
            return ResponseEntity.ok("Income deleted successfully");
        }else{
            return ResponseEntity.status(404).body("Income not found");
        }
    }

}
