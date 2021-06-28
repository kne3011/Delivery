package com.epam.delivery.service;

import com.epam.delivery.dao.TegDao;
import com.epam.delivery.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class CreateTegService implements Service{
    private final TegDao tegDao = new TegDao();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        String name = request.getParameter("name");
        String message = tegDao.createTeg(name);
        request.setAttribute("message", message);
        request.getRequestDispatcher("/DeliveryController/main").forward(request, response);
    }
}
