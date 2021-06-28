package com.epam.delivery.service;

import com.epam.delivery.dao.ProductDao;
import com.epam.delivery.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;

public class LoadBasketService implements Service{
    private final ProductDao productDao = new ProductDao();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        Cookie cookies[] = request.getCookies();
        HashMap<Product, Integer> products = new HashMap<>();
        int AllPrice = 0;
        for (int i = 0; i < cookies.length; i++) {
            Cookie ck = cookies[i];
            if (!ck.getName().equals("JSESSIONID")) {
                long id = Long.parseLong(ck.getName());
                Product product = productDao.getProduct(id);
                Integer count = Integer.valueOf(ck.getValue());
                products.put(product, count);
                AllPrice = AllPrice + (product.getPrice() * count);
            }
        }
        request.setAttribute("products", products);
        request.setAttribute("price", AllPrice);
        request.getRequestDispatcher("/my_basket.jsp").forward(request, response);
    }
}
