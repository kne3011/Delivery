package com.epam.delivery.service;

import com.epam.delivery.dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class UpdateProductService implements Service{
    private final ProductDao productDao = new ProductDao();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        String name = request.getParameter("name");
        long id = Long.parseLong(request.getParameter("id"));
        long type = Long.parseLong(request.getParameter("type"));
        String desc = request.getParameter("description");
        String photo = request.getParameter("photo");
        int price = Integer.parseInt(request.getParameter("price"));
        String message = productDao.changeProduct(id, name, type, desc, photo, price);
        request.setAttribute("message", message);
        request.getRequestDispatcher("/DeliveryController/main").forward(request, response);
    }
}
