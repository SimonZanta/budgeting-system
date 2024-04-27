package com.example.MyBankingApp.Service;

import com.example.MyBankingApp.Model.BudgetPlan;
import com.example.MyBankingApp.Model.Transaction;
import com.example.MyBankingApp.Model.TransactionCategory;
import com.example.MyBankingApp.Repository.BudgetRepo;
import com.example.MyBankingApp.Repository.TransactionCategoryRepo;
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
    @Autowired
    private TransactionCategoryRepo transactionCategoryRepo;
    public Map<String, Object> getAllTransactions() {

        // find all budget plans
        List<BudgetPlan> findAllBudgetPlansId = budgetRepo.findAllBudgetPlans();

        // create response map
        Map<String, Object> response = new HashMap<>();

        // loop through all budgets and find transactions that belong to specific budget
        for(BudgetPlan budget : findAllBudgetPlansId){
            Map<String, Object> budgetDetail = new HashMap<>();
            Map<String, Object> transactions = new HashMap<>();

            // finad all transactions under some budget
            List<Object[]> data = transactionRepo.findTransactionsSummary(budget.getId());

            for (Object[] row : data) {
                Transaction transaction = (Transaction) row[0];
                Map<String, Object> transactionDetail = new HashMap<>();


                transactionDetail.put("id", transaction.getBudgetPlanId());
                transactionDetail.put("name", transaction.getTransactionName());
                transactionDetail.put("value", transaction.getTransactionValue());
                transactionDetail.put("date", transaction.getTransactionDate());
                transactionDetail.put("category", transactionCategoryRepo.findById(transaction.getTransactionCategoryId()));

                transactions.put(transaction.getTransactionName(), transactionDetail);

            }

            int amountTotal = transactionRepo.sumAllTransactionsById(budget.getId());
            int amountLeft = budget.getAmount() - amountTotal;
            budgetDetail.put("Transactions", transactions);
            budgetDetail.put("name", budget.getBudgetName());
            budgetDetail.put("amount", budget.getAmount());
            budgetDetail.put("amountTotal", amountTotal);
            budgetDetail.put("amountLeft", amountLeft);
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
