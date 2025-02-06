package com.example.demo_Full_Stack_Project.fullstack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    private double totalIncome;
    private double totalExpense;
    private double balance;
}
