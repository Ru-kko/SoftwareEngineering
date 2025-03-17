package com.parcial.parcial1.infra.servlets;

import com.parcial.parcial1.application.inputports.ReservationService;
import com.parcial.parcial1.application.services.InMemoryReservationService;
import lombok.SneakyThrows;

import java.io.*;
import java.util.UUID;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(value = "/cancel")
public class DeleteServlet extends HttpServlet {
    private final ReservationService reservationService = InMemoryReservationService.getInstance();

    @Override
    @SneakyThrows
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        String id = req.getParameter("id");

        if (id == null) {
            res.sendRedirect("reservations.jsp");
            return;
        }

        UUID uuid = UUID.fromString(id);

        reservationService.cancel(uuid);
        res.sendRedirect("reservations.jsp");
    }
}