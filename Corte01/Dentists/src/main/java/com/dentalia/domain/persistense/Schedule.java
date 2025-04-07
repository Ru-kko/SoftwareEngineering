package com.dentalia.domain.persistense;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalTime;
import java.util.UUID;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    @Id
    private UUID id;
    private LocalTime startHour;
    private LocalTime endHour;
}
