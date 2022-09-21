package org.sid.projetstage.services;


import org.sid.projetstage.dtos.*;
import org.sid.projetstage.entities.DayExpenses;
import org.sid.projetstage.entities.MonthExpenses;
import org.sid.projetstage.exceptions.*;

import java.util.List;

public interface PersonService {

    //***************Manager****************************
    ManagerDTO saveManager(ManagerDTO managerDTO);

    ManagerDTO updateManager(ManagerDTO managerDTO);

    ManagerDTO getManager(String managerId) throws ManagerNotFoundException;

    void deleteManager(String managerId);

    List<ManagerDTO> searchManagers(String keyword);

    //***************Employee****************************
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployee(String employeeId) throws EmployeeNotFoundException;

    void deleteEmployee(String employeeId);

    List<EmployeeDTO> searchEmployees(String keyword);

    //***************Project****************************
    ProjectDTO saveProject(ProjectDTO projectDTO);

    ProjectDTO updateProject(ProjectDTO projectDTO);

    ProjectDTO getProject(String projectId) throws ProjectNotFoundException;

    void deleteProject(String projectId);

    List<ProjectDTO> searchProjects(String keyword);



    //***************DayExpenses****************************
    DayExpensesDTO saveDayExpenses(DayExpensesDTO dayExpensesDTO);

    DayExpensesDTO updateDayExpenses(DayExpensesDTO dayExpensesDTO);

    DayExpensesDTO getDayExpenses(String dayExpensesId) throws DayExpensesNotFoundException;

    void deleteDayExpenses(String dayExpensesId);

    List<DayExpensesDTO> searchDayExpenses(String keyword);

    List<DayExpensesDTO> listDayExpenses();

    //***************MonthExpenses****************************
    MonthExpensesDTO saveMonthExpenses(MonthExpensesDTO monthExpensesDTO);

    MonthExpensesDTO updateMonthExpenses(MonthExpensesDTO monthExpensesDTO);

    MonthExpensesDTO getMonthExpenses(String monthExpensesId) throws MonthExpensesNotFoundException;

    void deleteMonthExpenses(String monthExpensesId);

    List<MonthExpensesDTO> searchMonthExpenses(String keyword);

    List<MonthExpensesDTO> listMonthExpenses();

    List<PersonDTO> listPersons();

    //pagination
    //ProjectDTO getProject(int page, int size);

    ProjectPagesDTO allProjects(int page, int size);
    DayExpensesPagesDTO allDayExpenses(int page, int size);
    MonthExpensesPagesDTO allMonthExpenses(int page, int size);

    EmployePagesDTO allEmployee(int page, int size);
    ManagersPagesDTO allManager(int page, int size);


}
