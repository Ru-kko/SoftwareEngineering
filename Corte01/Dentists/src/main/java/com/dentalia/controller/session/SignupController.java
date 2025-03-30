package com.dentalia.controller.session;

import com.dentalia.domain.User;
import com.dentalia.dto.UserDto;
import lombok.SneakyThrows;
import lombok.extern.java.Log;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Log
@WebServlet(urlPatterns = "/signup")
public class SignupController extends HttpServlet {
    private final UserDto userDto = UserDto.getInstance();

    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        HttpSession session = req.getSession();
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        User user = User.builder()
                .id(UUID.randomUUID())
                .email(email)
                .name(name)
                .password(password)
                .build();

        userDto.save(user);

        session.setAttribute("user", user);
        res.sendRedirect( "/");
    }
}
