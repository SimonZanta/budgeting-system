package com.example.MyBankingApp.Service;

import com.example.MyBankingApp.Model.BudgetPlan;
import com.example.MyBankingApp.Model.Transaction;
import com.example.MyBankingApp.Repository.BudgetRepo;
import com.example.MyBankingApp.Repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.*;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;
    @Autowired
    private BudgetRepo budgetRepo;
    public Map<String, Object> getAllTransactions() {

        // find all budget plans
        List<BudgetPlan> findAllBudgetPlansId = budgetRepo.findAllBudgetPlans();

        // create response map
        Map<String, Object> response = new HashMap<>();

        // loop through all budgets and find transactions that belong to specific budget
        for(BudgetPlan budget : findAllBudgetPlansId){
            Map<String, Object> budgetDetail = new HashMap<>();
            Map<String, Transaction> transactions = new HashMap<>();

            // finad all transactions under some budget
            List<Object[]> data = transactionRepo.findTransactionsSummary(budget.getId());

            for (Object[] row : data) {
                Transaction transaction = (Transaction) row[0];


                transactions.put(transaction.getTransactionName(),
                        new Transaction(
                                transaction.getBudgetPlanId(),
                                transaction.getTransactionName(),
                                transaction.getTransactionValue(),
                                transaction.getTransactionDate(),
                                transaction.getTransactionCategoryId()
                        ));
            }

            budgetDetail.put("Transactions", transactions);
            budgetDetail.put("name", budget.getBudgetName());
            budgetDetail.put("amount", budget.getAmount());
            budgetDetail.put("dateFrom", budget.getDateFrom());
            budgetDetail.put("dateTo", budget.getDateTo());

            response.put(budget.getBudgetName(), budgetDetail);
        }

        return response;
    }

    public Transaction addNewTransaction(Transaction transaction) {
        Optional<Long> id = Optional.ofNullable(budgetRepo.findBudgetIdByDate(transaction.getTransactionDate()));

        if(id.isPresent()){
            transaction.setBudgetPlanId(id.get());
            transactionRepo.save(transaction);
            return transaction;
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Budget for this timeframe not created");
    }
}
