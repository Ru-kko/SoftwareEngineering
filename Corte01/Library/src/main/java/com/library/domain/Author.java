package com.library.domain;


import javax.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID authorId;

    private String authorName;

    @Temporal(TemporalType.DATE)
    private Date authorBirth;

    private String authorDni;
}
