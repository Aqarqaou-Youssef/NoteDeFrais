package org.sid.projetstage.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@DiscriminatorValue("MANAGER")
@NoArgsConstructor @AllArgsConstructor
public class Manager extends Person{
    @OneToMany(mappedBy = "manager")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Employee> employees;
}
