package com.dentalia.controller.session;

import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogOutController extends HttpServlet {
    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        req.getSession().invalidate();

        res.sendRedirect( "/");
    }
}
