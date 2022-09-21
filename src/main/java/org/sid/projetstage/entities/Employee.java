package org.sid.projetstage.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.projetstage.enumes.FunctionType;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@DiscriminatorValue("EMPLOYEE")
@NoArgsConstructor @AllArgsConstructor
public class Employee extends Person{
    @Enumerated(EnumType.STRING)
    private FunctionType functionType;
    @ManyToOne
    private Project project;
    @OneToOne
    private MonthExpenses monthExpenses;
    @ManyToOne
    private Manager manager;
}
