package com.library.domain;

import javax.persistence.*;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "\"User\"")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    private String username;
    private String email;
    private String password;
}
