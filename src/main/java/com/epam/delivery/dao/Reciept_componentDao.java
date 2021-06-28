package com.epam.delivery.dao;

import com.epam.delivery.database.connection.ConnectionPool;
import com.epam.delivery.entity.Reciept_component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class Reciept_componentDao {
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private static ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static Connection connection = connectionPool.takeConnection();

    public String createRecieptComponent(long product_id, long reciept_id) {
        String check = "Reciept component do not added";
        try {
            String sql = "INSERT INTO Reciept_component values(null, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, product_id);
            preparedStatement.setLong(2, reciept_id);
            preparedStatement.execute();
            check = "Success";
        } catch (SQLException e) {
            LOGGER.warn(e);
            e.printStackTrace();
        }
        return check;
    }


}
