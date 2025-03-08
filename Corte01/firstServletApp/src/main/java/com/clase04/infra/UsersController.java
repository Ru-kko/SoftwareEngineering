package com.clase04.infra;

import com.clase04.domain.Usr;
import com.clase04.persistence.UserPersistence;
import lombok.SneakyThrows;
import lombok.extern.java.Log;

import java.util.List;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Log
@WebServlet(urlPatterns = "/svUsers")
public class UsersController extends HttpServlet {
    private final UserPersistence userAccess = UserPersistence.getInstance();
    @Override
    @SneakyThrows
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        List<Usr> users = userAccess.getAll();
        HttpSession session = req.getSession();
        session.setAttribute("users", users);

        res.sendRedirect("showUsers.jsp");
    }

    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        String name = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");

        Usr user = Usr.builder().email(email).fisrtname(name).lastname(lastName).build();
        log(user.toString());


        userAccess.save(user);
        doGet(req, res);
    }
}
