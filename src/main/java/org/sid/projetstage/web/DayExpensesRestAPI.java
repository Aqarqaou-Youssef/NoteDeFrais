package org.sid.projetstage.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.projetstage.dtos.DayExpensesDTO;
import org.sid.projetstage.dtos.DayExpensesPagesDTO;
import org.sid.projetstage.dtos.MonthExpensesDTO;
import org.sid.projetstage.dtos.MonthExpensesPagesDTO;
import org.sid.projetstage.exceptions.DayExpensesNotFoundException;
import org.sid.projetstage.exceptions.MonthExpensesNotFoundException;
import org.sid.projetstage.services.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class DayExpensesRestAPI {
    private PersonService personService;
/*
    @GetMapping("/dayExpenses")
    public List<DayExpensesDTO> dayExpensesDTOList(){
        return personService.listDayExpenses();
    }*/

    @GetMapping("/dayExpenses")
    public DayExpensesPagesDTO listDayExpenses(@RequestParam(name = "page", defaultValue = "0") int page,
                                               @RequestParam(name = "size", defaultValue = "5") int size){
        return personService.allDayExpenses(page,size);
    }

    @GetMapping("/dayExpenses/search")
    public List<DayExpensesDTO> searchDayExpenses(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return personService.searchDayExpenses("%"+keyword+"%");
    }

    @GetMapping("/dayExpenses/{id}")
    public DayExpensesDTO getMonthExpenses(@PathVariable(name = "id") String dayExpensesId) throws DayExpensesNotFoundException {
        return personService.getDayExpenses(dayExpensesId);
    }

    @PostMapping("/dayExpenses")
    public DayExpensesDTO saveDayExpenses(@RequestBody DayExpensesDTO dayExpensesDTO){
        return personService.saveDayExpenses(dayExpensesDTO);
    }

    @PutMapping("/dayExpenses/{dayExpensesId}")
    public DayExpensesDTO updateDayExpenses(@PathVariable String dayExpensesId, @RequestBody DayExpensesDTO dayExpensesDTO){
        dayExpensesDTO.setId(dayExpensesId);
        return personService.updateDayExpenses(dayExpensesDTO);
    }

    @DeleteMapping("/dayExpenses/{id}")
    public void deleteDayExpenses(@PathVariable String id){
        personService.deleteDayExpenses(id);
    }

}
