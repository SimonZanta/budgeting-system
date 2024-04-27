package com.example.MyBankingApp.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "budeget_plans")
public class BudgetPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //amount calculate in crowns
    private int amount;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String BudgetName;

    public BudgetPlan(){}
    public BudgetPlan(int amount, LocalDate dateFrom, LocalDate dateTo, String budgetName) {
        this.amount = amount;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        BudgetName = budgetName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public String getBudgetName() {
        return BudgetName;
    }

    public void setBudgetName(String budgetName) {
        BudgetName = budgetName;
    }

}
