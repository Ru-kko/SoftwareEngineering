package com.clase04.infra;

import com.clase04.domain.Usr;
import com.clase04.persistence.UserPersistence;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.extern.java.Log;

import java.util.List;

@Log
@WebServlet("/svUser/*")
public class SingleUserController extends HttpServlet {
    private final UserPersistence userAccess = UserPersistence.getInstance();

    @SneakyThrows
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        String pathInfo = req.getPathInfo();

        if (pathInfo == null) {
            res.sendRedirect("/");
            return;
        }
        try {
            pathInfo = pathInfo.substring(1);
            Integer id = Integer.parseInt(pathInfo);

            Usr user = userAccess.findById(id).orElseThrow();

            req.getSession().setAttribute("user-edit", user);
            req.getRequestDispatcher("/editUser.jsp").forward(req, res);
        } catch (Exception e) {
            log.warning(e.getMessage());
            res.sendRedirect("/");
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        try {
            Usr user = (Usr) req.getSession().getAttribute("user-edit");
            if (user == null) {
                res.sendRedirect("/");
                return;
            }

            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String email = req.getParameter("email");

            user.setFisrtname(firstName);
            user.setLastname(lastName);
            user.setEmail(email);

            userAccess.update(user);

            List<Usr> users = userAccess.getAll();
            req.getSession().setAttribute("users", users);
            res.sendRedirect("/showUsers.jsp");
        } catch (Exception e) {
            log.warning(e.getMessage());
            res.sendRedirect("/");
        }
    }
}
