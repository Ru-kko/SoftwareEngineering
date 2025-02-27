package com.clase04.domain;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usr")
public class Usr {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fisrtname")
    private String fisrtname;

    @Column(name = "lastname")
    private String lastname;

}