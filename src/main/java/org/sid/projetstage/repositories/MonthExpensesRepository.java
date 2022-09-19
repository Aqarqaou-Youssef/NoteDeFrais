package org.sid.projetstage.repositories;

import org.sid.projetstage.entities.MonthExpenses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthExpensesRepository extends JpaRepository<MonthExpenses,String> {
}
