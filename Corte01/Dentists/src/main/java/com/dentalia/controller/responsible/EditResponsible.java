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
import java.util.Optional;
import java.util.UUID;

@WebServlet(urlPatterns = "/responsible/edit")
public class EditResponsible extends HttpServlet {
    private final ResponsibleRepository responsibleRepository = ResponsibleRepository.getInstance();
    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        HttpSession session = req.getSession();
        Object userSession = session.getAttribute("user");

        if (userSession == null) {
            session.setAttribute("error", ErrorPopup.builder()
                    .level(ErrorPopup.Level.ERROR)
                    .message("You are not logged in")
                    .build());
            res.sendRedirect(req.getContextPath() + "/");
            return;
        }

        String id = req.getParameter("id");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String birthDate = req.getParameter("birthDate");
        String dni = req.getParameter("dni");

        Optional<Responsible> original = responsibleRepository.findById(UUID.fromString(id));

        if (original.isEmpty()) {
            session.setAttribute("error", ErrorPopup.builder()
                    .message("Responsible not found")
                    .level(ErrorPopup.Level.ERROR)
                    .build());
            res.sendRedirect(req.getContextPath() + "/responsible/edit.jsp");
            return;
        }

        if (dni != null && !dni.matches("\\d+")) {
            session.setAttribute("error", ErrorPopup.builder()
                    .message("DNI must be an integer")
                    .level(ErrorPopup.Level.ERROR)
                    .build());
            res.sendRedirect(req.getContextPath() + "/responsible/edit.jsp");
            return;
        }

        Responsible responsible = original.get();

        if (firstName != null && !firstName.isEmpty()) responsible.setFirstName(firstName);
        if (lastName != null && !lastName.isEmpty()) responsible.setLastName(lastName);
        if (dni != null && !dni.isEmpty()) responsible.setDni(dni);
        if (birthDate != null && !birthDate.isEmpty()) {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            responsible.setBirthDate(formatter.parse(birthDate));
        }

        responsibleRepository.update(responsible);

        res.sendRedirect(req.getContextPath() + "/responsible");
    }
}
