package com.example.MyBankingApp.Controller;

import com.example.MyBankingApp.Model.BudgetPlan;
import com.example.MyBankingApp.Service.BudgetService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/budget")
public class BudgetController {
    private BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @PostMapping("/add")
    public BudgetPlan addNewBudget(@RequestBody BudgetPlan budgetPlan){
        BudgetPlan newBudgetPlan = budgetService.addNewBudget(budgetPlan);
        return newBudgetPlan;
    }
}
