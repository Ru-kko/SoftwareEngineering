package com.dentalia.controller.user;

import com.dentalia.dao.UserRepository;
import com.dentalia.domain.persistense.User;
import com.dentalia.domain.util.ErrorPopup;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.UUID;

@WebServlet(urlPatterns = "/users/edit")
public class EditUser extends HttpServlet {
    private final UserRepository userRepository = UserRepository.getInstance();
    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") == null) {
            res.sendRedirect("/");
            return;
        }
        User sessionUser = (User) session.getAttribute("user");
        String id = req.getParameter("id");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        Optional<User> original = userRepository.findById(UUID.fromString(id));

        if (original.isEmpty()) {
            req.getSession().setAttribute("error", ErrorPopup.builder().message("User not found").level(ErrorPopup.Level.ERROR).build());
            res.sendRedirect(req.getContextPath() + "/users/edit.jsp");
            return;
        }
        User user = original.get();

        if (email != null && !email.isEmpty()) user.setEmail(email);
        if (name != null && !name.isEmpty()) user.setName(name);
        if (password != null && !password.isEmpty()) user.setPassword(password);
        if (role != null) user.setRole(User.Role.valueOf(role));

        userRepository.update(user);

        if (sessionUser.getId().equals(UUID.fromString(id))) {
            session.setAttribute("user", user);
        }
        res.sendRedirect("/users");
    }
}
