package com.example.MyBankingApp.Repository;

import com.example.MyBankingApp.Model.TransactionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionCategoryRepo extends JpaRepository<TransactionCategory, Long> {
}
