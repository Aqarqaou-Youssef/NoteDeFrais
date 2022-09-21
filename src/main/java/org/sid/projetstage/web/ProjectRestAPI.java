package org.sid.projetstage.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.projetstage.dtos.MonthExpensesDTO;
import org.sid.projetstage.dtos.ProjectDTO;
import org.sid.projetstage.dtos.ProjectPagesDTO;
import org.sid.projetstage.exceptions.ProjectNotFoundException;
import org.sid.projetstage.services.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class ProjectRestAPI {

    private PersonService personService;



    @GetMapping("/projects/search")
    public List<ProjectDTO> searchProjects(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return personService.searchProjects("%"+keyword+"%");
    }

    @GetMapping("/projects/{id}")
    public ProjectDTO getProject(@PathVariable(name = "id") String projectId) throws ProjectNotFoundException {
        return personService.getProject(projectId);
    }

    @PostMapping("/projects")
    public ProjectDTO saveProject(@RequestBody ProjectDTO projectDTO){
        return personService.saveProject(projectDTO);
    }

    @PutMapping("/projects/{projectId}")
    public ProjectDTO updateProject(@PathVariable String projectId, @RequestBody ProjectDTO projectDTO){
        projectDTO.setId(projectId);
        return personService.updateProject(projectDTO);
    }

    @DeleteMapping("/projects/{id}")
    public void deleteProject(@PathVariable String id){
        personService.deleteProject(id);
    }

    //pagination

    @GetMapping("/projects")
    public ProjectPagesDTO listProject(@RequestParam(name = "page", defaultValue = "0") int page,
                                     @RequestParam(name = "size", defaultValue = "5") int size){
        return personService.allProjects(page,size);
    }

}
