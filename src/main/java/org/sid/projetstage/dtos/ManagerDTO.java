package org.sid.projetstage.dtos;

import lombok.Data;

import java.util.List;
@Data
public class ManagerDTO extends PersonDTO {
    private List<EmployeeDTO> employeeDTOList;
}
