package com.epam.delivery.service;

import com.epam.delivery.dao.RecieptDao;
import com.epam.delivery.entity.Reciept;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class LoadHistoryService implements Service{
    private final RecieptDao recieptDao = new RecieptDao();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        HttpSession session = request.getSession();
        long user_id = (long) session.getAttribute("id");
        ArrayList<Reciept> reciepts = recieptDao.getHistoryOfUser(user_id);
        request.setAttribute("reciepts", reciepts);
        request.getRequestDispatcher("/history.jsp").forward(request, response);
    }
}
