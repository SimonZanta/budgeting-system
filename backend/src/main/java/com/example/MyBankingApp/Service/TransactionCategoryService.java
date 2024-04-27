package com.example.MyBankingApp.Service;

import com.example.MyBankingApp.Model.TransactionCategory;
import com.example.MyBankingApp.Repository.TransactionCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionCategoryService {
    @Autowired
    private TransactionCategoryRepo transactionCategoryRepo;

    public TransactionCategory addNewTransactionCategory(TransactionCategory transactionCategory) {
        transactionCategoryRepo.save(transactionCategory);
        return transactionCategory;
    }
}
