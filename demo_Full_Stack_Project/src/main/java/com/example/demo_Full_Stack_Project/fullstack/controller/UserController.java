package com.example.demo_Full_Stack_Project.fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_Full_Stack_Project.fullstack.model.User;
import com.example.demo_Full_Stack_Project.fullstack.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // Allow requests from React app
@RequestMapping("api/users")

public class UserController {

    @Autowired
     private UserService userService;
  
     @GetMapping("/all")
     public ResponseEntity<List<User>> getAllUsers(){
        
         List<User> users = userService.getAllUsers();
         return ResponseEntity.ok(users);
     }
       
    
     @PostMapping("/register")
     public ResponseEntity<User> register(@RequestBody User user){
         User RegisteredUser = userService.RegisterUser(user);
         return ResponseEntity.ok(RegisteredUser);
     }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user)
{
        User authenticatedUser = userService.authenticateUser(user.getEmail(), user.getPassword());

        if (authenticatedUser!=null){
            return ResponseEntity.ok(authenticatedUser);
        }
        return ResponseEntity.status(401).body("Invalid credentials");

    }

    @PutMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User UpdatedUser = userService.updateUser(user);
        return ResponseEntity.ok(UpdatedUser);
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@RequestBody User user){
        return userService.deleteUser(user);
    }

}
