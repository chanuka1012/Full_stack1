package com.example.demo_Full_Stack_Project.fullstack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Document(collection="Income")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Income {

    @Id
    private String id;
    private double amount;
    private String date;
    private String source;
    private String userId;
    

}
