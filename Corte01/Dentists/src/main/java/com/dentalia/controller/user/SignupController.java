package com.dentalia.controller.user;

import com.dentalia.dao.UserRepository;
import com.dentalia.domain.persistense.User;
import com.dentalia.domain.util.ErrorPopup;
import lombok.SneakyThrows;
import lombok.extern.java.Log;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Log
@WebServlet(urlPatterns = "/users/create")
public class SignupController extends HttpServlet {
    private final UserRepository userDto = UserRepository.getInstance();

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

        User userParse = (User) userSession;

        if (userParse.getRole() != User.Role.ADMIN) {
            session.setAttribute("error", ErrorPopup.builder().message("You are not admin").level(ErrorPopup.Level.WARNING).build());
            res.sendRedirect(req.getContextPath() + "/users/create.jsp");
            return;
        }

        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        User.Role role = User.Role.valueOf(req.getParameter("role"));

        User user = User.builder()
                .id(UUID.randomUUID())
                .email(email)
                .name(name)
                .password(password)
                .role(role)
                .build();

        userDto.save(user);

        res.sendRedirect("/users.jsp");
    }
}
