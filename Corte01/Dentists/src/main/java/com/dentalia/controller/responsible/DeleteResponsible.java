package com.dentalia.controller.responsible;

import com.dentalia.dao.ResponsibleRepository;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@WebServlet(urlPatterns = "/responsible/delete")
public class DeleteResponsible extends HttpServlet {
    private final ResponsibleRepository responsibleRepository = ResponsibleRepository.getInstance();

    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        String id = req.getParameter("id");
        responsibleRepository.deleteById(UUID.fromString(id));
        res.sendRedirect("/responsible");
    }
}
