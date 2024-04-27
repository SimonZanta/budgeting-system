package com.example.MyBankingApp.Controller;

import com.example.MyBankingApp.Model.User;
import com.example.MyBankingApp.Repository.UserRepo;
import com.example.MyBankingApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String LogIn(@RequestBody Map<String, String> body){
        String name = body.get("userName");
        String password = body.get("password");
        return userService.loginUser(name, password);
    };

    @GetMapping("/delete")
    public User DeleteUser(@RequestParam("id") Long id){
        return userService.deleteUser(id);
    }

    @PostMapping("/add")
    public User AddNewUser(@RequestBody User user){
        return userService.addNewUser(user);
    }
}
