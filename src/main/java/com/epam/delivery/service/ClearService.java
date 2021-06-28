package com.epam.delivery.service;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class ClearService implements Service{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        Cookie cookies[] = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            Cookie ck = cookies[i];
            ck.setMaxAge(0);
            ck.setValue(null);
            response.addCookie(ck);
        }
        request.getRequestDispatcher("/DeliveryController/main").forward(request, response);
    }
}
