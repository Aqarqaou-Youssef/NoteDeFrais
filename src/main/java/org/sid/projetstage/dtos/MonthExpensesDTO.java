package org.sid.projetstage.dtos;

import lombok.Data;
import org.sid.projetstage.entities.Employee;

import java.util.Date;
import java.util.List;

@Data
public class MonthExpensesDTO {
    private String id;
    private String name;
    private Date month;
    private Employee employee;
    private List<DayExpensesDTO> dayExpensesDTOList;
}
