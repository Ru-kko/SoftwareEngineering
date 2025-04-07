package com.dentalia.controller.session;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dentalia.domain.persistense.User;
import com.dentalia.dao.UserRepository;

import com.dentalia.domain.util.ErrorPopup;
import lombok.SneakyThrows;
import lombok.extern.java.Log;

@Log
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private final UserRepository userDto = UserRepository.getInstance();

    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        HttpSession session = req.getSession();
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Optional<User> user = userDto.findByEmail(email);

        if (user.isEmpty()) {
            session.setAttribute("error", ErrorPopup.builder().message("Invalid email.").level(ErrorPopup.Level.WARNING).build());
            res.sendRedirect(req.getContextPath() + "/");
            return;
        }

        if (!user.get().getPassword().equals(password)) {
            session.setAttribute("error", ErrorPopup.builder().message("Invalid password.").level(ErrorPopup.Level.WARNING).build());
            res.sendRedirect(req.getContextPath() + "/");
            return;
        }

        session.setAttribute("user", user.get());
        res.sendRedirect( "/");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       HttpSession session = req.getSession();
       session.removeAttribute("user");

       res.sendRedirect( "/");
    }
}
