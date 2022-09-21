package org.sid.projetstage.repositories;

import org.sid.projetstage.entities.DayExpenses;
import org.sid.projetstage.entities.MonthExpenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MonthExpensesRepository extends JpaRepository<MonthExpenses,String> {

    @Query("select c from MonthExpenses c where c.name like :kw")
    List<MonthExpenses> searchMonthExpenses(@Param("kw") String keyword);
}
