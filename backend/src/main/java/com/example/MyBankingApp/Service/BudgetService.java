package com.example.MyBankingApp.Service;

import com.example.MyBankingApp.Model.BudgetPlan;
import com.example.MyBankingApp.Repository.BudgetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetService {
    @Autowired
    private BudgetRepo budgetRepo;
    public BudgetPlan addNewBudget(BudgetPlan budgetPlan) {
        budgetRepo.save(budgetPlan);
        return budgetPlan;
    }
}
