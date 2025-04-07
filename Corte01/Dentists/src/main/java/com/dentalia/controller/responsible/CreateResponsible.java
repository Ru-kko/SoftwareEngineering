package com.dentalia.controller.responsible;

import com.dentalia.dao.ResponsibleRepository;
import com.dentalia.domain.persistense.Responsible;
import com.dentalia.domain.util.ErrorPopup;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@WebServlet(urlPatterns = "/responsible/create")
public class CreateResponsible extends HttpServlet {
    private final ResponsibleRepository responsibleRepository = ResponsibleRepository.getInstance();

    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        HttpSession session = req.getSession();
        Object userSession = session.getAttribute("user");

        if (userSession == null) {
            session.setAttribute("error", ErrorPopup.builder().level(ErrorPopup.Level.ERROR).message("You are not logged in").build());
            res.sendRedirect(req.getContextPath() + "/");
            return;
        }

        UUID id = UUID.randomUUID();
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String birthDate = req.getParameter("birthDate");
        String dni = req.getParameter("dni");

        if (!dni.matches("\\d+")) {
            session.setAttribute("error", ErrorPopup.builder().message("DNI must be an integer").level(ErrorPopup.Level.ERROR).build());
            res.sendRedirect(req.getContextPath() + "/responsible/create.jsp");
            return;
        }

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(birthDate);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -18);
        Date minAllowed = cal.getTime();

        if (date.after(minAllowed)) {
            session.setAttribute("error", ErrorPopup.builder()
                    .message("Responsible must be at least 18 years old")
                    .level(ErrorPopup.Level.ERROR)
                    .build());
            res.sendRedirect(req.getContextPath() + "/responsible/create.jsp");
            return;
        }

        Responsible responsible = Responsible.builder()
                .id(id)
                .dni(dni)
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(date)
                .build();

        responsibleRepository.save(responsible);
        res.sendRedirect(req.getContextPath() + "/responsible/create.jsp");
    }
}
