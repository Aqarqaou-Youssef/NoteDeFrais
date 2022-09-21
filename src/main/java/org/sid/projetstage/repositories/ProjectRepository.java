package org.sid.projetstage.repositories;

import org.sid.projetstage.entities.MonthExpenses;
import org.sid.projetstage.entities.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,String> {

    @Query("select c from Project c where c.name like :kw")
    List<Project> searchProject(@Param("kw") String keyword);
//pagination
    Page<Project> findAll(Pageable pageable);

}
