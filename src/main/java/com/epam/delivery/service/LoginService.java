package com.epam.delivery.service;

import com.epam.delivery.dao.UserDao;
import com.epam.delivery.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class LoginService implements Service{
    private final UserDao userDao = new UserDao();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userDao.Login(email, password);
        if (user == null){
            request.setAttribute("message", "Not correct password or email");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }else {
            request.setAttribute("message", "Success log in");
            HttpSession session = request.getSession();
            session.setAttribute("id",user.getId());
            session.setAttribute("name", user.getName());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("address" , user.getAddress());
            session.setAttribute("status", user.getStatus());
            request.getRequestDispatcher("/DeliveryController/main").forward(request, response);
        }
    }
}
