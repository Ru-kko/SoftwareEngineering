package com.parcial.parcial1.infra.servlets;

import com.parcial.parcial1.application.inputports.ReservationService;
import com.parcial.parcial1.application.services.InMemoryReservationService;
import com.parcial.parcial1.domain.OfficeType;
import com.parcial.parcial1.domain.Reservation;
import lombok.SneakyThrows;
import lombok.extern.java.Log;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Log
@WebServlet("/reservation-servlet")
public class ReservationServlet extends HttpServlet {
    private final ReservationService reservationService = InMemoryReservationService.getInstance();
    @Override
    @SneakyThrows
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = req.getParameter("date");
            String email = req.getParameter("email");
            String type = req.getParameter("type");
            String hoursStr = req.getParameter("hours");

            if (dateStr == null || email == null || type == null || hoursStr == null || dateStr.isEmpty() || email.isEmpty() || type.isEmpty() || hoursStr.isEmpty()) {
                throw new NullPointerException();
            }

            Integer hours = Integer.parseInt(hoursStr);

            Reservation reservation = Reservation.builder()
                    .email(email)
                    .officeType(OfficeType.valueOf(req.getParameter("type")))
                    .reservedHours(hours)
                    .reservedDate(dateFormat.parse(dateStr))
                    .build();

            reservationService.reserve(reservation);
            res.sendRedirect("reservations.jsp");
        } catch (NullPointerException e) {
            log.throwing("ReservationServlet", "doPost", e);
            req.getSession().setAttribute("error_message", "Falta informacion");
            res.sendRedirect("/");
        } catch (IllegalArgumentException | ParseException e) {
            log.throwing("ReservationServlet", "doPost", e);
            req.getSession().setAttribute("error_message", "Informacion Incorrecta");
            res.sendRedirect("/");
        }
    }
}
