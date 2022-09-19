package org.sid.projetstage.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.projetstage.enumes.FunctionType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends Person{
    @Enumerated(EnumType.STRING)
    private FunctionType functionType;
    @ManyToOne
    private Project project;
    @ManyToOne
    private DayExpenses dayExpenses;
    @ManyToOne
    private Manager manager;
}
