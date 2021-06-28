package com.epam.delivery.service;

import com.epam.delivery.dao.ProductDao;
import com.epam.delivery.dao.TegDao;
import com.epam.delivery.entity.Product;
import com.epam.delivery.entity.Teg;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class LoadMainService implements Service{
    private final ProductDao productDao = new ProductDao();
    private final TegDao tegDao = new TegDao();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        ArrayList<Product> products = productDao.getAllProduct();
        HashMap<Product, ArrayList<Teg>> productsAndTheirTegs = new HashMap<>();
        for (int i = 0; i < products.size(); i ++){
            long productId = products.get(i).getId();
            ArrayList<Teg> productTegs = tegDao.getAllTegOfProduct(productId);
            productsAndTheirTegs.put(products.get(i), productTegs);
        }
        HttpSession session = request.getSession();
        request.setAttribute("productsAndTheirTegs", productsAndTheirTegs);
        ArrayList<Teg> tegs = tegDao.getAllTeg();
        request.setAttribute("Tegs", tegs);
        if (session.getAttribute("status") != null && (long) session.getAttribute("status") == 2){
            request.getRequestDispatcher("/adminMain.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("/main.jsp").forward(request, response);
        }
    }
}
