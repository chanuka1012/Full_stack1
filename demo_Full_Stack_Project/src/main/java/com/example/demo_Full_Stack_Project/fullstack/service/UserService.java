package com.example.demo_Full_Stack_Project.fullstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo_Full_Stack_Project.fullstack.model.User;
import com.example.demo_Full_Stack_Project.fullstack.repo.UserRepo;

@Service
@Transactional

public class UserService {

    @Autowired
    private UserRepo userRepo; 

    

    public User RegisterUser(User user) {
        
        return userRepo.save(user);
    }

    public List<User> getAllUsers(){
		return userRepo.findAll();
	}

    public User authenticateUser(String email, String password) {
        User user = userRepo.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
        return user;
    }
        return null;
    }

    public User updateUser(User user){
        return userRepo.save(user);
    }

    

    public boolean deleteUser(User user) {
        try {
            userRepo.delete(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
