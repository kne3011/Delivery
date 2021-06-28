package com.epam.delivery.service;

import com.epam.delivery.dao.TegDao;
import com.epam.delivery.dao.Teg_listDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class DeleteTegService implements Service {
    private final TegDao tegDao = new TegDao();
    private final Teg_listDao teg_listDao = new Teg_listDao();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        long id = Long.parseLong(request.getParameter("id"));
        String message = teg_listDao.DeleteAllTegFromTeg_list(id);
        if (message.equals("Success")) {
            message = tegDao.deleteTeg(id);
        }
        request.setAttribute("message", message);
        request.getRequestDispatcher("/DeliveryController/main").forward(request, response);
    }
}