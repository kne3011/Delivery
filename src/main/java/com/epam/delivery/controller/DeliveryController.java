package com.epam.delivery.controller;

import com.epam.delivery.service.Service;
import com.epam.delivery.service.factory.ServiceFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeliveryController extends HttpServlet {

  private final ServiceFactory serviceFactory = ServiceFactory.getInstance();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String requestUri = req.getRequestURI();
    Service currentService = serviceFactory.getService(requestUri);
    try {
      currentService.execute(req, resp);
    } catch (ParseException | SQLException e) {
      System.out.println(e);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
