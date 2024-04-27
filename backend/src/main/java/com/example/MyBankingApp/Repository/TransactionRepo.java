package com.example.MyBankingApp.Repository;

import com.example.MyBankingApp.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface TransactionRepo extends JpaRepository<Transaction, Long>{
        @Query(value = "SELECT t.* " +
                "FROM  t " +
                "INNER JOIN BudgetPlan b ON t.budgetPlan_id = b.id " +
                "WHERE t.date BETWEEN :startDate AND :endDate", nativeQuery = true)
        List<Map<String, Object>> findTransactionsByTimeframe(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
