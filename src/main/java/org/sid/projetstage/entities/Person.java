package org.sid.projetstage.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)


public abstract class Person {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private double salary;
}
