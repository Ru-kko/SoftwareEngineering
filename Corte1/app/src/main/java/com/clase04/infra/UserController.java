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
public class UserController extends HttpServlet {
    private final UserPersistence userAccess = new UserPersistence();
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
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        Usr user = Usr.builder().id(id).fisrtname(name).lastname(lastName).build();
        log(user.toString());


        userAccess.save(user);
        res.sendRedirect("showUsers.jsp");
    }
}
