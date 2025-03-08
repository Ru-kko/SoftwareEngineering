package com.library.domain;

import lombok.*;

import javax.persistence.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookStock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID physicBookId;

    @ManyToOne(targetEntity = Book.class, fetch = FetchType.EAGER)
    private Book book;
}
