package org.sid.projetstage.dtos;

import lombok.Data;

import java.util.List;

@Data
public class PersonDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private double salary;
    private String typePerson;

}
