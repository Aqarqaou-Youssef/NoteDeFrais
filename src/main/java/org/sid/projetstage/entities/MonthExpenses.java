package org.sid.projetstage.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthExpenses {
    @Id
    private String id;
    private String name;
    private Date month;
    @OneToMany(mappedBy = "monthExpenses")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<DayExpenses> dayExpenses;
    @OneToOne
    private Employee employee;
}
