package com.dentalia.controller.user;

import com.dentalia.dao.UserRepository;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@WebServlet(urlPatterns = "/users/delete")
public class DeleteUser extends HttpServlet  {
    private final UserRepository userRepository = UserRepository.getInstance();
    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        UUID id = UUID.fromString(req.getParameter("id"));
        userRepository.deleteById(id);
        res.sendRedirect("/users");
    }
}
