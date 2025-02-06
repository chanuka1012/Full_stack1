package com.example.demo_Full_Stack_Project.fullstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo_Full_Stack_Project.fullstack.model.Account;
import com.example.demo_Full_Stack_Project.fullstack.repo.AccountRepo;

@Service
@Transactional

public class AccountService {

    @Autowired
    private AccountRepo accountRepo;

    // Save a new account
    public Account saveAccount(Account account) {
        return accountRepo.save(account);
    }

    // Get all accounts for a specific user
    public List<Account> getAccountsByUserId(String userId) {
        return accountRepo.findByUserId(userId);
    }

    // Update an account by ID
    public Account updateAccountById(String id, Account account) {
        if (accountRepo.existsById(id)) {
            account.setId(id); // Ensure the correct ID is set
            return accountRepo.save(account);
        } else {
            return null; // Return null if the account doesn't exist
        }
    }

    // Delete an account by ID
    public boolean deleteAccountById(String id) {
        if (accountRepo.existsById(id)) {
            accountRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
