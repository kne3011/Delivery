package com.epam.delivery.service;

import com.epam.delivery.dao.ProductDao;
import com.epam.delivery.dao.RecieptDao;
import com.epam.delivery.dao.Reciept_componentDao;
import com.epam.delivery.entity.Product;
import com.epam.delivery.entity.Reciept;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;

public class BuyService implements Service {
    private final RecieptDao recieptDao = new RecieptDao();
    private final ProductDao productDao = new ProductDao();
    private final Reciept_componentDao reciept_componentDao = new Reciept_componentDao();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        String type = request.getParameter("type");
        long millis =System.currentTimeMillis();
        Date date = new Date(millis);
        HttpSession session = request.getSession();
        long user_id = (long) session.getAttribute("id");
        Cookie cookies[] = request.getCookies();
        int price = 0;
        for (int i = 0; i < cookies.length; i++) {
            Cookie ck = cookies[i];
            if (!ck.getName().equals("JSESSIONID")) {
                long id = Long.parseLong(ck.getName());
                Product product = productDao.getProduct(id);
                int count = Integer.parseInt(ck.getValue());
                price = price + (product.getPrice() * count);
            }
        }
        long recieptId = recieptDao.createReciept(type, date, price, user_id);
        if (recieptId != -1){
            for (int i = 0; i < cookies.length; i++) {
                Cookie ck = cookies[i];
                if (!ck.getName().equals("JSESSIONID")) {
                    long id = Long.parseLong(ck.getName());
                    reciept_componentDao.createRecieptComponent(id, recieptId);
                }
            }
        }
        request.getRequestDispatcher("/DeliveryController/main").forward(request, response);
    }
}
