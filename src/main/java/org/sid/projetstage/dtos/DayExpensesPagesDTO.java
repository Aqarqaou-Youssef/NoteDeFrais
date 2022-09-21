package org.sid.projetstage.dtos;

import lombok.Data;
import org.sid.projetstage.entities.DayExpenses;

import java.util.List;

@Data
public class DayExpensesPagesDTO {
    private int currentPage;
    private int totalPage;
    private int size;
    private List<DayExpensesDTO> dayExpensesDTOList;
}
