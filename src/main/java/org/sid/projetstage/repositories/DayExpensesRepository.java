package org.sid.projetstage.repositories;

import org.sid.projetstage.entities.DayExpenses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayExpensesRepository extends JpaRepository<DayExpenses,String> {
}
