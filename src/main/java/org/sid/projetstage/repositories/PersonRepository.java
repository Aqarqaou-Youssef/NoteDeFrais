package org.sid.projetstage.repositories;

import org.sid.projetstage.entities.Employee;
import org.sid.projetstage.entities.Manager;
import org.sid.projetstage.entities.Person;
import org.sid.projetstage.entities.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,String> {

    @Query("select c from Manager c where c.lastName like :kw")
    List<Manager> searchManager(@Param("kw") String keyword);

    @Query("select c from Employee c where c.lastName like :kw")
    List<Employee> searchEmployee(@Param("kw") String keyword);

    Page<Person> findAll(Pageable pageable);
}
