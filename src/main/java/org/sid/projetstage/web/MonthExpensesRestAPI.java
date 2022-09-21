package org.sid.projetstage.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.projetstage.dtos.*;
import org.sid.projetstage.exceptions.MonthExpensesNotFoundException;
import org.sid.projetstage.exceptions.ProjectNotFoundException;
import org.sid.projetstage.services.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class MonthExpensesRestAPI {

    private PersonService personService;
/*
    @GetMapping("/monthExpenses")
    public List<MonthExpensesDTO> monthExpensesDTOList(){
        return personService.listMonthExpenses();}*/

    @GetMapping("/monthExpenses")
    public MonthExpensesPagesDTO listMonthExpenses(@RequestParam(name = "page", defaultValue = "0") int page,
                                             @RequestParam(name = "size", defaultValue = "5") int size){
        return personService.allMonthExpenses(page,size);
    }

    @GetMapping("/monthExpenses/search")
        public List<MonthExpensesDTO> searchMonthExpenses(@RequestParam(name = "keyword",defaultValue = "") String keyword){
            return personService.searchMonthExpenses("%"+keyword+"%");
        }

        @GetMapping("/monthExpenses/{id}")
        public MonthExpensesDTO getMonthExpenses(@PathVariable(name = "id") String monthExpensesId) throws MonthExpensesNotFoundException {
            return personService.getMonthExpenses(monthExpensesId);
        }

        @PostMapping("/monthExpenses")
        public MonthExpensesDTO saveMonthExpenses(@RequestBody MonthExpensesDTO monthExpensesDTO){
            return personService.saveMonthExpenses(monthExpensesDTO);
        }

        @PutMapping("/monthExpenses/{monthExpensesId}")
        public MonthExpensesDTO updateMonthExpenses(@PathVariable String monthExpensesId, @RequestBody MonthExpensesDTO monthExpensesDTO){
            monthExpensesDTO.setId(monthExpensesId);
            return personService.updateMonthExpenses(monthExpensesDTO);
        }

        @DeleteMapping("/monthExpenses/{id}")
        public void deleteMonthExpenses(@PathVariable String id){
            personService.deleteMonthExpenses(id);
        }
    }

