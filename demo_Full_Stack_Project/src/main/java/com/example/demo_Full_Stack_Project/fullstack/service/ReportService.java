package com.example.demo_Full_Stack_Project.fullstack.service;

import java.util.List;

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

    public Report generateReport(String userId) {
        List<Income> incomes = incomeRepo.findByUserId(userId);
        List<Expense> expenses = expenseRepo.findByUserId(userId);

        double totalIncome = incomes.stream().mapToDouble(Income::getAmount).sum();
        double totalExpense = expenses.stream().mapToDouble(Expense::getAmount).sum();
        double balance = totalIncome - totalExpense;

        return new Report(totalIncome, totalExpense, balance);
    }

}
