package com.parcial.parcial1.application.inputports;

import com.parcial.parcial1.domain.Reservation;

import java.util.Map;
import java.util.UUID;

public interface ReservationService {
    void reserve(Reservation reservation);
    Map<UUID, Reservation> getReservations();
    void cancel(UUID reservationId);

}
