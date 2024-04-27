package com.example.MyBankingApp.Service;

import com.example.MyBankingApp.Model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User addNewUser(User user);
    User deleteUser(Long id);
    String loginUser(String name, String Password);
}
