package com.dentalia.controller.schedule;

import com.dentalia.domain.persistense.Schedule;
import com.dentalia.dao.ScheduleRepository;
import com.dentalia.domain.util.ErrorPopup;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalTime;
import java.util.UUID;

@WebServlet(urlPatterns = "/schedule/create")
public class CreateSchedule extends HttpServlet {
    private final ScheduleRepository dto = ScheduleRepository.getInstance();

    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        UUID id = UUID.randomUUID();
        LocalTime startHour = LocalTime.parse(req.getParameter("startHour"));
        LocalTime endHour = LocalTime.parse(req.getParameter("endHour"));

        if (!startHour.isBefore(endHour)) {
            ErrorPopup error = ErrorPopup.builder()
                    .level(ErrorPopup.Level.ERROR)
                    .message("Start hour must be before end hour.")
                    .build();

            req.getSession().setAttribute("error", error);
            res.sendRedirect("/schedule/create.jsp");
            return;
        }

        Schedule schedule = Schedule.builder()
                .id(id)
                .startHour(startHour)
                .endHour(endHour)
                .build();
        dto.save(schedule);

        res.sendRedirect("/schedule");
    }
}
