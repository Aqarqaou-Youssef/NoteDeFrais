package org.sid.projetstage.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DayExpenses {
    @Id
    private String id;
    private double amount;
    private Date day;
    private String description;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Project project;
    @ManyToOne
    private MonthExpenses monthExpenses;
}
