package com.example.demo_Full_Stack_Project.fullstack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Users1")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public String getPassword(){
        return password;
    }

}
