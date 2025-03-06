package com.example.demo_Full_Stack_Project.fullstack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="Income")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Income {

    @Id
    private String id;
    private double amount;
    private String date;
    private String source;
    private String userId;
    public String getCategory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCategory'");
    }

}
