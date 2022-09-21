package org.sid.projetstage.dtos;


import lombok.Data;
import org.sid.projetstage.enumes.FunctionType;

import javax.persistence.ManyToOne;
import java.util.List;
@Data
public class EmployeeDTO extends PersonDTO {
    private String functionType;
}
