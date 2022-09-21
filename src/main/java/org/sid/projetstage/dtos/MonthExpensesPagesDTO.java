package org.sid.projetstage.dtos;

import lombok.Data;
import org.sid.projetstage.entities.DayExpenses;
import org.sid.projetstage.entities.MonthExpenses;

import java.util.List;

@Data
public class MonthExpensesPagesDTO {
    private int currentPage;
    private int totalPage;
    private int size;
    private List<MonthExpensesDTO> monthExpensesList;
}
