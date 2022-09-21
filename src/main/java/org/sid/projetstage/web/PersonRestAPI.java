package org.sid.projetstage.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.projetstage.dtos.*;
import org.sid.projetstage.entities.Manager;
import org.sid.projetstage.entities.Person;
import org.sid.projetstage.exceptions.EmployeeNotFoundException;
import org.sid.projetstage.exceptions.ManagerNotFoundException;
import org.sid.projetstage.exceptions.ProjectNotFoundException;
import org.sid.projetstage.mappers.ProjectMapperImpl;
import org.sid.projetstage.services.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class PersonRestAPI {

    private ProjectMapperImpl dtoMapper;
    private PersonService personService;
    //************************************Managers******************************************
/*
    @GetMapping("/managers")
    public List<ManagerDTO> getManager(){
        return personService.listPersons().stream()
            .filter(p->p instanceof ManagerDTO)
            .map(p->{ return (ManagerDTO) p; }).toList();
    }*/

    @GetMapping("/managers")
    public ManagersPagesDTO listManager(@RequestParam(name = "page", defaultValue = "0") int page,
                                        @RequestParam(name = "size", defaultValue = "5") int size){
        return personService.allManager(page,size);
    }

    @GetMapping("/managers/search")
    public List<ManagerDTO> searchManagers(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return personService.searchManagers("%"+keyword+"%");
    }

    @GetMapping("/managers/{id}")
    public ManagerDTO getManager(@PathVariable(name = "id") String managerId) throws ManagerNotFoundException {
        return personService.getManager(managerId);
    }

    @PostMapping("/managers")
    public ManagerDTO saveManager(@RequestBody ManagerDTO managerDTO){
        return personService.saveManager(managerDTO);
    }

    @PutMapping("/managers/{managerId}")
    public ManagerDTO updateManager(@PathVariable String managerId, @RequestBody ManagerDTO managerDTO){
        managerDTO.setId(managerId);
        return personService.updateManager(managerDTO);
    }

    @DeleteMapping("/managers/{id}")
    public void deleteManager(@PathVariable String id){
        personService.deleteManager(id);
    }

    //************************************Employees******************************************
/*
    @GetMapping("/employees")
    public List<EmployeeDTO> getEmployee(){
        return personService.listPersons().stream()
                .filter(p->p instanceof EmployeeDTO)
                .map(p->{ return (EmployeeDTO) p; }).toList();
    }*/

    @GetMapping("/employeess")
    public EmployePagesDTO listEmployee(@RequestParam(name = "page", defaultValue = "0") int page,
                                       @RequestParam(name = "size", defaultValue = "5") int size){
        return personService.allEmployee(page,size);
    }

    @GetMapping("/employee/search")
    public List<EmployeeDTO> searchEmployees(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return personService.searchEmployees("%"+keyword+"%");
    }

    @GetMapping("/employee/{id}")
    public EmployeeDTO getEmployee(@PathVariable(name = "id") String employeeId) throws EmployeeNotFoundException {
        return personService.getEmployee(employeeId);
    }

    @PostMapping("/employees")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        return personService.saveEmployee(employeeDTO);
    }

    @PutMapping("/employees/{employeeId}")
    public EmployeeDTO updateEmployee(@PathVariable String employeeId, @RequestBody EmployeeDTO employeeDTO){
        employeeDTO.setId(employeeId);
        return personService.updateEmployee(employeeDTO);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable String id){
        personService.deleteEmployee(id);
    }

}
