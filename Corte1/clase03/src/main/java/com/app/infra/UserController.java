package com.app.infra;

import com.app.domain.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

@Log
@WebServlet(urlPatterns = "/svUsers")
public class UserController extends HttpServlet {
    @Override
    @SneakyThrows
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        List<User> users = new ArrayList<>();

        users.add(User.builder().id(1).firstName("Jonh").lastName("Doe").build());
        users.add(User.builder().id(2).firstName("Jane").lastName("Doe").build());
        users.add(User.builder().id(3).firstName("Diego").lastName("Cortizo").build());

        HttpSession session = req.getSession();
        session.setAttribute("users", users);

        res.sendRedirect("showUsers.jsp");
    }

    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        User user = User.builder().id(id).firstName(name).lastName(lastName).build();

        log(user.toString());
    }
}
