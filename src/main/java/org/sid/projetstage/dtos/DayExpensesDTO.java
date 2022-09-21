package org.sid.projetstage.dtos;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DayExpensesDTO {
    private String id;
    private String name;
    private double amount;
    private Date day;
    private String description;


}
