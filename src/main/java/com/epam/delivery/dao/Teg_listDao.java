package com.epam.delivery.dao;

import com.epam.delivery.database.connection.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Teg_listDao {
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private static ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static Connection connection = connectionPool.takeConnection();

    public String addTegToProduct(Long Teg_id, Long Product_id){
        String check = "Teg do not added to product";
        try {
            String sql = "INSERT INTO Teg_list values(null, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, Product_id);
            preparedStatement.setLong(2, Teg_id);
            preparedStatement.execute();
            check = "Success";
        } catch (SQLException e) {
            LOGGER.warn(e);
            e.printStackTrace();
        }
        return check;
    }

    public String DeleteTegFromProduct(Long Teg_id, Long Product_id){
        String check = "Teg do not deleted from product";
        try {
            String sql = "DELETE FROM Teg_list WHERE teg_id = ? AND product_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, Teg_id);
            preparedStatement.setLong(2, Product_id);
            preparedStatement.execute();
            check = "Success";
        } catch (SQLException e) {
            LOGGER.warn(e);
            e.printStackTrace();
        }
        return check;
    }

    public String DeleteAllTegFromTeg_list(Long Teg_id){
        String check = "All tegs with id do not deleted";
        try {
            String sql = "DELETE FROM Teg_list WHERE teg_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, Teg_id);
            preparedStatement.execute();
            check = "Success";
        } catch (SQLException e) {
            LOGGER.warn(e);
            e.printStackTrace();
        }
        return check;
    }

    public String DeleteAllProductFromTeg_list(Long Product_id){
        String check = "All Product with id do not deleted";
        try {
            String sql = "DELETE FROM Teg_list WHERE product_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, Product_id);
            preparedStatement.execute();
            check = "Success";
        } catch (SQLException e) {
            LOGGER.warn(e);
            e.printStackTrace();
        }
        return check;
    }
}
