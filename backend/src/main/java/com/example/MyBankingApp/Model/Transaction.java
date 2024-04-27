package com.example.MyBankingApp.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String transactionName;
    private int transactionValue;
    private LocalDate transactionDate;
    private Long transactionCategoryId;
    private Long budgetPlanId;

    public Transaction(){}

    public Transaction(Long budgetPlanId, String transactionName, int transactionValue, LocalDate transactionDate, Long transactionCategoryId) {
        this.budgetPlanId = budgetPlanId;
        this.transactionName = transactionName;
        this.transactionValue = transactionValue;
        this.transactionDate = transactionDate;
        this.transactionCategoryId = transactionCategoryId;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public int getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(int transactionValue) {
        this.transactionValue = transactionValue;
    }

    public Long getTransactionCategoryId() {
        return transactionCategoryId;
    }

    public void setTransactionCategoryId(Long transactionCategoryId) {
        this.transactionCategoryId = transactionCategoryId;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Long getBudgetPlanId() {
        return budgetPlanId;
    }

    public void setBudgetPlanId(Long budgetPlanId) {
        this.budgetPlanId = budgetPlanId;
    }
}
