package com.example.MyBankingApp.Repository;

import com.example.MyBankingApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT user FROM User user WHERE user.username = :userName")
    User findUserByName(@Param("userName") String userName);

}
