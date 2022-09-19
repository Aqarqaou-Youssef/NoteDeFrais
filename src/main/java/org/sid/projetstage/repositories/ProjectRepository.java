package org.sid.projetstage.repositories;

import org.sid.projetstage.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,String> {
}
