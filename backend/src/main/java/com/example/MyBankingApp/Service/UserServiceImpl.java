package com.example.MyBankingApp.Service;

import com.example.MyBankingApp.Model.User;
import com.example.MyBankingApp.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepository;

    @Autowired

    public UserServiceImpl(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.delete(user.get());
            return user.get();
        }
        return null;
    }

    //implement login when i have time
    @Override
    public String loginUser(String name, String Password) {
        Optional<User> user = Optional.ofNullable(userRepository.findUserByName(name));
        if(user.isPresent()){
            return "loggedIn";
        }
        return "wrong user name";
    }
}
