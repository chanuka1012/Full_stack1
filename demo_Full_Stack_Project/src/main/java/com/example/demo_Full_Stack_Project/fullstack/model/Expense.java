package com.example.demo_Full_Stack_Project.fullstack.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "Expense")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Expense {

    
    @Id
    private String id;
    private double amount;
    private String date;
    private String category;
    private String description;
    private String userId;
    
}
