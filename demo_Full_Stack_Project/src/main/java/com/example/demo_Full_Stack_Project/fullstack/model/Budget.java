package com.example.demo_Full_Stack_Project.fullstack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="Budget")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Budget {

    @Id
    private String id;
    private double amount;
    private String category;
    private String period;//monthly,weekly or daily
    private String userId;

    //method to check if expenses exceed the budget limit
    public boolean checkLimit(double expenses){
        return expenses <= amount;
    }

    //method to adjust budget amount
    public void adjustBudget(double newAmount){
        this.amount=newAmount;
    }

}
