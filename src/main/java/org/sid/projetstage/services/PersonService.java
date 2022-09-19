package org.sid.projetstage.services;

import org.sid.projetstage.dtos.EmployeeDTO;
import org.sid.projetstage.dtos.ManagerDTO;

public interface PersonService {

    ManagerDTO saveManager(ManagerDTO managerDTO);
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
}
