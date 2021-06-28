package com.epam.delivery.service;

import com.epam.delivery.dao.Teg_listDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class DeleteTegToProductService implements Service {
    private final Teg_listDao teg_listDao = new Teg_listDao();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        long product_id = Long.parseLong(request.getParameter("id"));
        long teg_id = Long.parseLong(request.getParameter("teg"));
        String message = teg_listDao.DeleteTegFromProduct(teg_id, product_id);
        request.setAttribute("message", message);
        request.getRequestDispatcher("/DeliveryController/main").forward(request, response);
    }
}