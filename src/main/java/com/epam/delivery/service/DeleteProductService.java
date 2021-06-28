package com.epam.delivery.service;

import com.epam.delivery.dao.ProductDao;
import com.epam.delivery.dao.TegDao;
import com.epam.delivery.dao.Teg_listDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class DeleteProductService implements Service {
    private final ProductDao productDao = new ProductDao();
    private final Teg_listDao teg_listDao = new Teg_listDao();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        long id = Long.parseLong(request.getParameter("id"));
        String message = teg_listDao.DeleteAllProductFromTeg_list(id);
        if (message.equals("Success")) {
            message = productDao.deleteProduct(id);
        }
        request.setAttribute("message", message);
        request.getRequestDispatcher("/DeliveryController/main").forward(request, response);
    }
}