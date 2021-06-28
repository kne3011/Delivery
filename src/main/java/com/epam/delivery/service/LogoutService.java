package com.epam.delivery.service;

import com.epam.delivery.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class LogoutService implements Service {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        HttpSession session = request.getSession();
        session.removeAttribute("id");
        session.removeAttribute("name");
        session.removeAttribute("email");
        session.removeAttribute("address");
        session.removeAttribute("status");
        request.setAttribute("message", "Log out");
        request.getRequestDispatcher("/DeliveryController/main").forward(request, response);
    }
}
