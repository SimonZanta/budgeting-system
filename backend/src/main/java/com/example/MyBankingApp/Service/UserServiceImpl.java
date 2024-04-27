package com.example.MyBankingApp.Service;

import com.example.MyBankingApp.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepo userRepository;

    @Autowired

    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }
}
