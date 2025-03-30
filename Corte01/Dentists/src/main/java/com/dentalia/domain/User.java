package com.dentalia.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

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
    public UUID id;
    private String name;
    private String email;
    private String password;
}
