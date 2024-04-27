package com.example.MyBankingApp.Repository;

import com.example.MyBankingApp.Model.BudgetPlan;
import com.example.MyBankingApp.Model.Transaction;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {

        @Query("SELECT t " +
                "FROM Transaction t " +
                "WHERE t.budgetPlanId = :id ")
        List<Object[]> findTransactionsSummary(Long id);
}
