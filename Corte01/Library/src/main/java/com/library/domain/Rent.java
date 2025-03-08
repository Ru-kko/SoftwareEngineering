package com.library.domain;

import com.library.util.RentCompositeKey;
import javax.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rent {
    @EmbeddedId
    private RentCompositeKey key;

    @Temporal(TemporalType.DATE)
    private Date rentDate;
    @Temporal(TemporalType.DATE)
    private Date returnDate;

    @ManyToOne(targetEntity = BookStock.class, fetch = FetchType.EAGER)
    @MapsId("physicBookId")
    @JoinColumn(name = "physicBookId")
    private BookStock book;


    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @MapsId("userId")
    @JoinColumn(name = "userId")
    private User user;
}
