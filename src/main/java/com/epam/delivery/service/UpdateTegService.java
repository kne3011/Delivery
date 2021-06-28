package com.epam.delivery.service;

import com.epam.delivery.dao.TegDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class UpdateTegService implements Service{
    private final TegDao tegDao = new TegDao();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        String name = request.getParameter("name");
        long id = Long.parseLong(request.getParameter("id"));
        String message = tegDao.updateTeg(id, name);
        request.setAttribute("message", message);
        request.getRequestDispatcher("/DeliveryController/main").forward(request, response);
    }
}
