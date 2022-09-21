package org.sid.projetstage.repositories;

import org.sid.projetstage.entities.DayExpenses;
import org.sid.projetstage.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DayExpensesRepository extends JpaRepository<DayExpenses,String> {

    @Query("select c from DayExpenses c where c.name like :kw")
    List<DayExpenses> searchDayExpenses(@Param("kw") String keyword);
}
