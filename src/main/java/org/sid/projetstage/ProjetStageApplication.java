package org.sid.projetstage;

import org.sid.projetstage.entities.Employee;
import org.sid.projetstage.entities.Person;
import org.sid.projetstage.entities.Project;
import org.sid.projetstage.enumes.FunctionType;
import org.sid.projetstage.mappers.ProjectMapperImpl;
import org.sid.projetstage.repositories.PersonRepository;
import org.sid.projetstage.repositories.ProjectRepository;
import org.sid.projetstage.services.PersonServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ProjetStageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetStageApplication.class, args);
	}

	//@Bean
	CommandLineRunner start(ProjectRepository projectRepository){
		return args -> {
			Stream.of("Hassan","Yassine","Aicha","aaa","qdq","sdvc","sedcs","azdaz","azd","","qzd","srf").forEach(name->{
				Project project=new Project();
				project.setId(UUID.randomUUID().toString());
				project.setName(name);
				projectRepository.save(project);
			});
		};
	}
//@Bean
	CommandLineRunner start(PersonRepository personRepository){
		return args -> {
			Stream.of("Hassan","Yassine","Aicha","aaa","qdq","sdvc","sedcs","azdaz","azd","","qzd","srf").forEach(name->{
				Employee employee= new Employee();
				employee.setId(UUID.randomUUID().toString());
				employee.setEmail(name+"@gmail.com");
				employee.setSalary(Math.random()*90000);
				employee.setLastName(name);
				employee.setFirstName(name);
				employee.setFunctionType(FunctionType.BACKEND);
				personRepository.save(employee);
			});
		};
	}

	@Bean
	ProjectMapperImpl projectMapper(){
		return new ProjectMapperImpl();
	}


}
