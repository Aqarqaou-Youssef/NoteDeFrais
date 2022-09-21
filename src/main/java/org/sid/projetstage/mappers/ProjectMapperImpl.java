package org.sid.projetstage.mappers;

import org.sid.projetstage.dtos.*;
import org.sid.projetstage.entities.*;
import org.springframework.beans.BeanUtils;

public class ProjectMapperImpl {
    //****************day expenses***************************
    public DayExpensesDTO fromDayExpenses(DayExpenses dayExpenses){
        DayExpensesDTO dayExpensesDTO=new DayExpensesDTO();
        BeanUtils.copyProperties(dayExpenses,dayExpensesDTO);
        return  dayExpensesDTO;
    }

    public DayExpenses fromDayExpensesDTO(DayExpensesDTO dayExpensesDTO){
        DayExpenses dayExpenses = new DayExpenses();
        BeanUtils.copyProperties(dayExpensesDTO,dayExpenses);
        return  dayExpenses;
    }



    //****************month expenses***************************
    public MonthExpensesDTO fromMonthExpenses(MonthExpenses monthExpenses){
        MonthExpensesDTO monthExpensesDTO=new MonthExpensesDTO();
        BeanUtils.copyProperties(monthExpenses,monthExpensesDTO);
        monthExpensesDTO.setDayExpensesDTOList(monthExpenses.getDayExpenses().stream().map(this::fromDayExpenses).toList());
        return  monthExpensesDTO;
    }

    public MonthExpenses fromMonthExpensesDTO(MonthExpensesDTO monthExpensesDTO){
        MonthExpenses monthExpenses = new MonthExpenses();
        BeanUtils.copyProperties(monthExpensesDTO,monthExpenses);
        return  monthExpenses;
    }

    //****************manager***************************
    public ManagerDTO fromManager(Manager manager){
        ManagerDTO managerDTO=new ManagerDTO();
        BeanUtils.copyProperties(manager,managerDTO);
        return  managerDTO;
    }

    public Manager fromManagerDTO(ManagerDTO managerDTO){
        Manager manager = new Manager();
        BeanUtils.copyProperties(managerDTO,manager);
        return  manager;
    }

    //****************employee***************************
    public EmployeeDTO fromEmployee(Employee employee){
        EmployeeDTO employeeDTO=new EmployeeDTO();
        BeanUtils.copyProperties(employee,employeeDTO);
        return  employeeDTO;
    }

    public Employee fromEmployeeDTO(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        return  employee;
    }

    //******************projet***************************
    public ProjectDTO fromProject(Project project){
        ProjectDTO projectDTO=new ProjectDTO();
        BeanUtils.copyProperties(project,projectDTO);
        return  projectDTO;
    }

    public Project fromProjectDTO(ProjectDTO projectDTO){
        Project project = new Project();
        BeanUtils.copyProperties(projectDTO,project);
        return  project;
    }

}
