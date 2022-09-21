package org.sid.projetstage.dtos;

import lombok.Data;

import java.util.List;

@Data
public class EmployePagesDTO {
    private int currentPage;
    private int totalPage;
    private int size;
    private List<EmployeeDTO> employeeDTOList;
}
