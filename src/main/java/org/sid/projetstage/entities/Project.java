package org.sid.projetstage.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    private String id;
    @OneToMany(mappedBy = "project")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Employee> employees;
    @OneToMany(mappedBy = "project")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<DayExpenses> dayExpenses;
}
