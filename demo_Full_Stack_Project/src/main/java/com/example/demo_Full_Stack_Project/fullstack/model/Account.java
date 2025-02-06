package com.example.demo_Full_Stack_Project.fullstack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    private String id;
    private String name;       // Account name (e.g., Bank, Cash)
    private double balance;    // Current balance
    private String type;       // Account type (e.g., Savings, Credit)
    private String userId;     // ID of the user who owns the account

}
