package com.dentalia.controller.schedule;

import com.dentalia.dao.ScheduleRepository;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@WebServlet(urlPatterns = "/schedule/delete")
public class DeleteSchedule extends HttpServlet {
    private final ScheduleRepository dto = ScheduleRepository.getInstance();

    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        UUID id = UUID.fromString(req.getParameter("id"));
        dto.deleteById(id);
        res.sendRedirect("/schedule");
    }
}
