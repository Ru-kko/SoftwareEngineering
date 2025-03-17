package com.parcial.parcial1.application.services;

import com.parcial.parcial1.application.inputports.ReservationService;
import com.parcial.parcial1.domain.OfficeType;
import com.parcial.parcial1.domain.Reservation;
import lombok.extern.java.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Singleton service where implements an input port, like hexagonal architecture
 */
@Log
public class InMemoryReservationService implements ReservationService {
    private static InMemoryReservationService instance;
    private final Map<UUID, Reservation> reservations; // * Map for easier deletion

    private InMemoryReservationService() {
        this.reservations = new HashMap<>();

        try {
            // * Default test data
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            this.reservations.put(UUID.randomUUID(),
                    Reservation.builder()
                            .reservedDate(dateFormat.parse("12/03/2025"))
                            .email("jonh@doe.com")
                            .reservedHours(2)
                            .officeType(OfficeType.PRIVATE_OFFICE)
                            .build()
            );
            this.reservations.put(UUID.randomUUID(),
                    Reservation.builder()
                            .reservedDate(dateFormat.parse("20/03/2025"))
                            .email("jane@doe.com")
                            .reservedHours(2)
                            .officeType(OfficeType.METING_OFFICE)
                            .build()
            );
        } catch (ParseException ignore) {
            log.warning("Error parsing reservation date");
        }
    }

    public static InMemoryReservationService getInstance() {
        if (instance != null) return instance;

        instance = new InMemoryReservationService();
        return instance;
    }

    @Override
    public void reserve(Reservation reservation) {
        UUID uuid = UUID.randomUUID();

        reservations.put(uuid, reservation);
    }

    @Override
    public Map<UUID, Reservation> getReservations() {
        return reservations;
    }

    @Override
    public void cancel(UUID reservationId) {
        reservations.remove(reservationId);
    }
}
