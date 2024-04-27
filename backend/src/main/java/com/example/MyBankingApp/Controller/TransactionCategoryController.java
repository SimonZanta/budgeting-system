package com.example.MyBankingApp.Controller;

import com.example.MyBankingApp.Model.TransactionCategory;
import com.example.MyBankingApp.Service.TransactionCategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactionCategory")
public class TransactionCategoryController {
    private TransactionCategoryService transactionCategoryService;

    public TransactionCategoryController(TransactionCategoryService transactionCategoryService) {
        this.transactionCategoryService = transactionCategoryService;
    }

    @PostMapping("/add")
    public TransactionCategory addNewTransactionCategory(@RequestBody TransactionCategory transactionCategory){
        TransactionCategory newTransactionCategory =
                transactionCategoryService.addNewTransactionCategory(transactionCategory);
        return newTransactionCategory;
    }
}
