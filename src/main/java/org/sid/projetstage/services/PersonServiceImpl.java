package org.sid.projetstage.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.projetstage.dtos.*;
import org.sid.projetstage.entities.*;
import org.sid.projetstage.exceptions.*;
import org.sid.projetstage.mappers.ProjectMapperImpl;
import org.sid.projetstage.repositories.DayExpensesRepository;
import org.sid.projetstage.repositories.MonthExpensesRepository;
import org.sid.projetstage.repositories.PersonRepository;
import org.sid.projetstage.repositories.ProjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class PersonServiceImpl implements PersonService{
    private PersonRepository personRepository;
    private MonthExpensesRepository monthExpensesRepository;
    private DayExpensesRepository dayExpensesRepository;
    private ProjectRepository projectRepository;
    private ProjectMapperImpl dtoMapper;

    //***************Manager****************************
    @Override
    public ManagerDTO saveManager(ManagerDTO managerDTO) {
        log.info("Saving new Manager");
        Manager manager=dtoMapper.fromManagerDTO(managerDTO);
        Manager savedManager = personRepository.save(manager);
        return dtoMapper.fromManager(savedManager);
    }
    @Override
    public ManagerDTO updateManager(ManagerDTO managerDTO) {
        log.info("Saving new Manager");
        Manager manager=dtoMapper.fromManagerDTO(managerDTO);
        Manager savedManager = personRepository.save(manager);
        return dtoMapper.fromManager(savedManager);
    }

    @Override
    public ManagerDTO getManager(String managerId) throws ManagerNotFoundException {
        Manager manager = (Manager) personRepository.findById(managerId).orElseThrow(() -> new ManagerNotFoundException("Manager Not found"));
        return dtoMapper.fromManager(manager);
    }

    @Override
    public void deleteManager(String managerId){
        projectRepository.deleteById(managerId);
    }

    @Override
    public List<ManagerDTO> searchManagers(String keyword) {
        List<Manager> managers=personRepository.searchManager(keyword);
        List<ManagerDTO> managerDTOS = managers.stream().map(ob -> dtoMapper.fromManager(ob)).collect(Collectors.toList());
        return managerDTOS;
    }


    //***************Employee****************************

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO){
        log.info("Saving new Employee");
        Employee employee = dtoMapper.fromEmployeeDTO(employeeDTO);
        Employee savedEmployee = personRepository.save(employee);
        return dtoMapper.fromEmployee(savedEmployee);
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO){
        log.info("Saving new Employee");
        Employee employee = dtoMapper.fromEmployeeDTO(employeeDTO);
        Employee savedEmployee = personRepository.save(employee);
        return dtoMapper.fromEmployee(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployee(String employeeId) throws EmployeeNotFoundException {
        Employee employee = (Employee) personRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("Employee Not found"));
        return dtoMapper.fromEmployee(employee);
    }

    @Override
    public void deleteEmployee(String employeeId){
        projectRepository.deleteById(employeeId);
    }

    @Override
    public List<EmployeeDTO> searchEmployees(String keyword) {
        List<Employee> employees=personRepository.searchEmployee(keyword);
        List<EmployeeDTO> employeeDTOS = employees.stream().map(ob -> dtoMapper.fromEmployee(ob)).collect(Collectors.toList());
        return employeeDTOS;
    }

    //***************Project****************************

    @Override
    public ProjectDTO saveProject(ProjectDTO projectDTO){
        log.info("Saving new Project");
        Project project= dtoMapper.fromProjectDTO(projectDTO);
        Project savedProject = projectRepository.save(project);
        return dtoMapper.fromProject(savedProject);
    }
    @Override
    public ProjectDTO updateProject(ProjectDTO projectDTO){
        log.info("Saving new Project");
        Project project= dtoMapper.fromProjectDTO(projectDTO);
        Project savedProject = projectRepository.save(project);
        return dtoMapper.fromProject(savedProject);
    }

    @Override
    public ProjectDTO getProject(String projectId) throws ProjectNotFoundException {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new ProjectNotFoundException("Project Not found"));
        return dtoMapper.fromProject(project);
    }

    @Override
    public void deleteProject(String projectId){
        projectRepository.deleteById(projectId);
    }

    @Override
    public List<ProjectDTO> searchProjects(String keyword) {
        List<Project> projects=projectRepository.searchProject(keyword);
        List<ProjectDTO> projectDTOS = projects.stream().map(ob -> dtoMapper.fromProject(ob)).collect(Collectors.toList());
        return projectDTOS;
    }




    //***************DayExpenses****************************

    @Override
    public DayExpensesDTO saveDayExpenses(DayExpensesDTO dayExpensesDTO){
        log.info("Saving new DayExpenses");
        DayExpenses dayExpenses= dtoMapper.fromDayExpensesDTO(dayExpensesDTO);
        DayExpenses savedDayExpenses = dayExpensesRepository.save(dayExpenses);
        return dtoMapper.fromDayExpenses(savedDayExpenses);
    }

    @Override
    public DayExpensesDTO updateDayExpenses(DayExpensesDTO dayExpensesDTO){
        log.info("Saving new DayExpenses");
        DayExpenses dayExpenses= dtoMapper.fromDayExpensesDTO(dayExpensesDTO);
        DayExpenses savedDayExpenses = dayExpensesRepository.save(dayExpenses);
        return dtoMapper.fromDayExpenses(savedDayExpenses);
    }

    @Override
    public DayExpensesDTO getDayExpenses(String dayExpensesId) throws DayExpensesNotFoundException {
        DayExpenses dayExpenses = dayExpensesRepository.findById(dayExpensesId).orElseThrow(() -> new DayExpensesNotFoundException("DayExpenses Not found"));
        return dtoMapper.fromDayExpenses(dayExpenses);
    }

    @Override
    public void deleteDayExpenses(String dayExpensesId){
        dayExpensesRepository.deleteById(dayExpensesId);
    }

    @Override
    public List<DayExpensesDTO> searchDayExpenses(String keyword) {
        List<DayExpenses> dayExpenses=dayExpensesRepository.searchDayExpenses(keyword);
        List<DayExpensesDTO> dayExpensesDTOS = dayExpenses.stream().map(ob -> dtoMapper.fromDayExpenses(ob)).collect(Collectors.toList());
        return dayExpensesDTOS;
    }

    @Override
    public List<DayExpensesDTO> listDayExpenses() {
        List<DayExpenses> dayExpenses = dayExpensesRepository.findAll();
        List<DayExpensesDTO> dayExpensesDTOS = dayExpenses.stream()
                .map(dayExpenses1 -> dtoMapper.fromDayExpenses(dayExpenses1))
                .collect(Collectors.toList());
        return dayExpensesDTOS;
    }

    //***************MonthExpenses****************************

    @Override
    public MonthExpensesDTO saveMonthExpenses(MonthExpensesDTO monthExpensesDTO){
        log.info("Saving new DayExpenses");
        MonthExpenses monthExpenses= dtoMapper.fromMonthExpensesDTO(monthExpensesDTO);
        MonthExpenses savedMonthExpenses = monthExpensesRepository.save(monthExpenses);
        return dtoMapper.fromMonthExpenses(savedMonthExpenses);
    }
    @Override
    public MonthExpensesDTO updateMonthExpenses(MonthExpensesDTO monthExpensesDTO){
        log.info("Saving new DayExpenses");
        MonthExpenses monthExpenses= dtoMapper.fromMonthExpensesDTO(monthExpensesDTO);
        MonthExpenses savedMonthExpenses = monthExpensesRepository.save(monthExpenses);
        return dtoMapper.fromMonthExpenses(savedMonthExpenses);
    }

    @Override
    public MonthExpensesDTO getMonthExpenses(String monthExpensesId) throws MonthExpensesNotFoundException {
        MonthExpenses monthExpenses = monthExpensesRepository.findById(monthExpensesId).orElseThrow(() -> new MonthExpensesNotFoundException("MonthExpenses Not found"));
        return dtoMapper.fromMonthExpenses(monthExpenses);
    }

    @Override
    public void deleteMonthExpenses(String monthExpensesId){
        monthExpensesRepository.deleteById(monthExpensesId);
    }

    @Override
    public List<MonthExpensesDTO> searchMonthExpenses(String keyword) {
        List<MonthExpenses> monthExpenses=monthExpensesRepository.searchMonthExpenses(keyword);
        List<MonthExpensesDTO> monthExpensesDTOS = monthExpenses.stream().map(ob -> dtoMapper.fromMonthExpenses(ob)).collect(Collectors.toList());
        return monthExpensesDTOS;
    }

    @Override
    public List<MonthExpensesDTO> listMonthExpenses() {
        List<MonthExpenses> monthExpenses = monthExpensesRepository.findAll();
        List<MonthExpensesDTO> monthExpensesDTOS = monthExpenses.stream()
                .map(monthExpenses1 -> dtoMapper.fromMonthExpenses(monthExpenses1))
                .collect(Collectors.toList());
        return monthExpensesDTOS;
    }
    //****************************Person***************************************

    @Override
    public List<PersonDTO> listPersons(){
        List<Person> persons = personRepository.findAll();
        List<PersonDTO> personDTOS = persons.stream().map(person -> {
            if (person instanceof Manager) {
                Manager manager = (Manager) person;
                return dtoMapper.fromManager(manager);
            } else {
                Employee employee = (Employee) person;
                return dtoMapper.fromEmployee(employee);
            }
        }).collect(Collectors.toList());
        return personDTOS;
    }


//pagination
   /*
    public ProjectDTO getProject(int page, int size) {
        Project pro= (Project) projectRepository.findAll();
        Page<Project> projects = projectRepository.findAll(PageRequest.of(page, size));
        ProjectDTO projectDTO= new ProjectDTO();
        List<ProjectDTO> projectDTOS = projects.getContent().stream().map(op -> dtoMapper.fromProject(op)).collect(Collectors.toList());
        projectDTO.setProjectDTOS(projectDTOS);
        projectDTO.setCurrentPage(page);
        projectDTO.setPageSize(size);
        projectDTO.setName(pro.getName());
        projectDTO.setId(pro.getId());
        projectDTO.setTotalPages(projects.getTotalPages());
        return projectDTO;
    }*/
@Override
public ProjectPagesDTO allProjects(int page, int size) {
    ProjectPagesDTO projectPagesDTO = new ProjectPagesDTO();
    Page<Project> projectList = projectRepository.findAll(PageRequest.of(page, size));

    if (page >= projectList.getTotalPages()) {
        page = projectList.getTotalPages() - 1;
        projectList = projectRepository.findAll(PageRequest.of(page, size));
    }

    List<ProjectDTO> projectDTOList = projectList.stream().map(proj -> dtoMapper.fromProject(proj)).toList();
    projectPagesDTO.setProjectDTOList(projectDTOList);
    projectPagesDTO.setSize(size);
    projectPagesDTO.setCurrentPage(page);
    projectPagesDTO.setTotalPage(projectList.getTotalPages());
    return projectPagesDTO;
}

    @Override
    public DayExpensesPagesDTO allDayExpenses(int page, int size) {
        DayExpensesPagesDTO dayExpensesPagesDTO = new DayExpensesPagesDTO();
        Page<DayExpenses> dayExpensesList = dayExpensesRepository.findAll(PageRequest.of(page, size));

        if (page >= dayExpensesList.getTotalPages()) {
            page = dayExpensesList.getTotalPages() - 1;
            dayExpensesList = dayExpensesRepository.findAll(PageRequest.of(page, size));
        }

        List<DayExpensesDTO> dayExpensesDTOList = dayExpensesList.stream().map(proj -> dtoMapper.fromDayExpenses(proj)).toList();
        dayExpensesPagesDTO.setDayExpensesDTOList(dayExpensesDTOList);
        dayExpensesPagesDTO.setSize(size);
        dayExpensesPagesDTO.setCurrentPage(page);
        dayExpensesPagesDTO.setTotalPage(dayExpensesList.getTotalPages());
        return dayExpensesPagesDTO;
    }
    @Override
    public MonthExpensesPagesDTO allMonthExpenses(int page, int size) {
        MonthExpensesPagesDTO monthExpensesPagesDTO = new MonthExpensesPagesDTO();
        Page<MonthExpenses> monthExpensesList = monthExpensesRepository.findAll(PageRequest.of(page, size));

        if (page >= monthExpensesList.getTotalPages()) {
            page = monthExpensesList.getTotalPages() - 1;
            monthExpensesList = monthExpensesRepository.findAll(PageRequest.of(page, size));
        }

        List<MonthExpensesDTO> monthExpensesDTOList = monthExpensesList.stream().map(proj -> dtoMapper.fromMonthExpenses(proj)).toList();
        monthExpensesPagesDTO.setMonthExpensesList(monthExpensesDTOList);
        monthExpensesPagesDTO.setSize(size);
        monthExpensesPagesDTO.setCurrentPage(page);
        monthExpensesPagesDTO.setTotalPage(monthExpensesList.getTotalPages());
        return monthExpensesPagesDTO;
    }

    @Override
    public EmployePagesDTO allEmployee(int page, int size) {
        EmployePagesDTO employePagesDTO = new EmployePagesDTO();
        Page<Person> employeeList = personRepository.findAll(PageRequest.of(page, size));

        if (page >= employeeList.getTotalPages()) {
            page = employeeList.getTotalPages() - 1;
            employeeList = personRepository.findAll(PageRequest.of(page, size));
        }

        employePagesDTO.setEmployeeDTOList(
                employeeList.stream().map(
                                person -> {
                                    if (person instanceof Employee)
                                        return dtoMapper.fromEmployee((Employee) person);
                                    else
                                        return null;
                                }
                        ).filter(p -> p != null)
                        .toList());
        employePagesDTO.setSize(size);
        employePagesDTO.setCurrentPage(page);
        employePagesDTO.setTotalPage(employeeList.getTotalPages());
        return employePagesDTO;
    }

    @Override
    public ManagersPagesDTO allManager(int page, int size) {
        ManagersPagesDTO managersPagesDTO = new ManagersPagesDTO();
        Page<Person> managerList = personRepository.findAll(PageRequest.of(page, size));

        if (page >= managerList.getTotalPages()) {
            page = managerList.getTotalPages() - 1;
            managerList = personRepository.findAll(PageRequest.of(page, size));
        }

        managersPagesDTO.setManagerDTOList(
                managerList.stream().map(
                                person -> {
                                    if (person instanceof Manager)
                                        return dtoMapper.fromManager((Manager) person);
                                    else
                                        return null;
                                }
                        ).filter(p -> p != null)
                        .toList());
        managersPagesDTO.setSize(size);
        managersPagesDTO.setCurrentPage(page);
        managersPagesDTO.setTotalPage(managerList.getTotalPages());
        return managersPagesDTO;
    }

}
