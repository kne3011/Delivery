package com.epam.delivery.service;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class AddToCurtService implements Service {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        String id = request.getParameter("id");
        Cookie cookies[] = request.getCookies();
        int check = 0;
        int minute = 60;
        for (int i = 0; i < cookies.length; i++) {
            Cookie ck = cookies[i];
            if (ck.getName().equals(id)){
                int newVal = Integer.parseInt(ck.getValue());
                ck.setValue(String.valueOf(newVal + 1));
                ck.setMaxAge(minute * 60);
                response.addCookie(ck);
                check = 1;
            }
        }
        if (check == 0){
            Cookie ck = new Cookie(id, "1");
            ck.setMaxAge(minute * 60);
            response.addCookie(ck);
        }
        request.getRequestDispatcher("/DeliveryController/main").forward(request, response);
    }
}
