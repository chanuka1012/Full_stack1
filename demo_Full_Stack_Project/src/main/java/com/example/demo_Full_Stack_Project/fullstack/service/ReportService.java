package com.example.demo_Full_Stack_Project.fullstack.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_Full_Stack_Project.fullstack.model.Expense;
import com.example.demo_Full_Stack_Project.fullstack.model.Income;
import com.example.demo_Full_Stack_Project.fullstack.model.Report;
import com.example.demo_Full_Stack_Project.fullstack.repo.ExpenseRepo;
import com.example.demo_Full_Stack_Project.fullstack.repo.IncomeRepo;

@Service
public class ReportService {

    @Autowired
    private ExpenseRepo expenseRepo;

    @Autowired
    private IncomeRepo incomeRepo;

    public Map<String, Object> generateReportByCategory(String userId, String startDate, String endDate) {
        List<Income> incomes = incomeRepo.findByUserIdAndDateBetween(userId, startDate, endDate);
        List<Expense> expenses = expenseRepo.findByUserIdAndDateBetween(userId, startDate, endDate);

        // Aggregate income by source
        Map<String, Double> incomeData = new HashMap<>();
        double totalIncome = 0.0;
        for (Income income : incomes) {
            incomeData.put(income.getSource(), incomeData.getOrDefault(income.getSource(), 0.0) + income.getAmount());
            totalIncome += income.getAmount();
        }

        // Aggregate expense by category
        Map<String, Double> expenseData = new HashMap<>();
        double totalExpense = 0.0;
        for (Expense expense : expenses) {
            expenseData.put(expense.getCategory(), expenseData.getOrDefault(expense.getCategory(), 0.0) + expense.getAmount());
            totalExpense += expense.getAmount();
        }

        // Calculate balance
        double balance = totalIncome - totalExpense;

        // Prepare response
        Map<String, Object> reportData = new HashMap<>();
        reportData.put("income", incomeData);
        reportData.put("expense", expenseData);
        reportData.put("totalIncome", totalIncome);
        reportData.put("totalExpense", totalExpense);
        reportData.put("balance", balance);
        return reportData;
    }

}
