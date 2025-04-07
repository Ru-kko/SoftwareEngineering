package com.dentalia.domain.persistense;

import java.util.UUID;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity(name = "usr")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private UUID id;
    private String name;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {DENTIST, ADMIN}
}
