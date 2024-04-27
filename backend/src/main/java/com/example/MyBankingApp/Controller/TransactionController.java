package com.example.MyBankingApp.Controller;

import com.example.MyBankingApp.Model.Transaction;
import com.example.MyBankingApp.Service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllTransactions(){
        Map<String, Object> response = transactionService.getAllTransactions();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add")
    public Transaction addNewTransaction(@RequestBody Transaction transaction){
        Transaction newTransaction = transactionService.addNewTransaction(transaction);
        return newTransaction;
    }
}
