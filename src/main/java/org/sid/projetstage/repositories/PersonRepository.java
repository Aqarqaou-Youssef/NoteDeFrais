package org.sid.projetstage.repositories;

import org.sid.projetstage.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,String> {
}
