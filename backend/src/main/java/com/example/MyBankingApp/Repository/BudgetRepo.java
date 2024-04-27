package com.example.MyBankingApp.Repository;

import com.example.MyBankingApp.Model.BudgetPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BudgetRepo extends JpaRepository<BudgetPlan, Long> {

    @Query("SELECT b "+
            "FROM BudgetPlan b ")
    List<BudgetPlan> findAllBudgetPlans();

    @Query("SELECT b.id " +
            "FROM BudgetPlan b "+
            "WHERE :date BETWEEN b.dateFrom AND b.dateTo")
    Long findBudgetIdByDate(LocalDate date);
}
