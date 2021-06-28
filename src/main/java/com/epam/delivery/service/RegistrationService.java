package com.epam.delivery.service;

import com.epam.delivery.dao.UserDao;
import com.epam.delivery.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class RegistrationService implements Service{
    private final UserDao userDao = new UserDao();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String name = request.getParameter("username");
        String message = userDao.registerUser(email, password, name, address);
        request.setAttribute("message", message);
        if (!message.equals("Success")){
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
