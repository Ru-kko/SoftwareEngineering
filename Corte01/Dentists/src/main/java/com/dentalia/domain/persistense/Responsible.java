package com.dentalia.domain.persistense;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Responsible {
    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private String dni;
    @Temporal(TemporalType.DATE)
    @Column(name= "birthDate")
    private Date birthDate;
}
