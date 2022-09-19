package org.sid.projetstage.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.projetstage.enumes.PersonType;

import javax.persistence.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",length = 6)

public abstract class Person {
    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    private PersonType Type;
    private String firstName;
    private String lastName;
    private String email;
}
