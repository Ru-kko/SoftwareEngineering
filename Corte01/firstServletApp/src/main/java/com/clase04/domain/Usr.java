package com.clase04.domain;

import lombok.*;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Builder
@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usr")
public class Usr implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fisrtname")
    private String fisrtname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;
}