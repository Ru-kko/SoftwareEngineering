package com.parcial.parcial1.domain;

import lombok.*;

import java.util.Date;

@Data
@Builder(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    private String email;
    private Integer reservedHours;
    private Date reservedDate;
    private OfficeType officeType;
}
