package com.epam.delivery.dao;

import com.epam.delivery.database.connection.ConnectionPool;
import com.epam.delivery.entity.Teg;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TegDao {
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private static ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static Connection connection = connectionPool.takeConnection();

    public String createTeg(String TegName){
        String check = "Teg do not added";
        try {
            String sql = "INSERT INTO Teg values(null, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, TegName);
            preparedStatement.execute();
            check = "Success";
        } catch (SQLException e) {
            LOGGER.warn(e);
            e.printStackTrace();
        }
        return check;
    }

    public String updateTeg(Long id, String name){
        String check = "Teg do not change";
        try {
            String sql = "UPDATE Teg SET name = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, id);
            preparedStatement.execute();
            check = "Success";
        } catch (SQLException e) {
            LOGGER.warn(e);
            e.printStackTrace();
        }
        return check;
    }

    public String deleteTeg(Long TegId){
        String check = "Teg do not delete";
        try {
            String sql = "DELETE FROM Teg WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, TegId);
            preparedStatement.execute();
            check = "Success";
        } catch (SQLException e) {
            LOGGER.warn(e);
            e.printStackTrace();
        }
        return check;
    }

    public ArrayList<Teg> getAllTegOfProduct(Long ProductId){
        ArrayList<Teg> tegs = new ArrayList<>();
        try {
            String sql = "SELECT Teg.id, Teg.name FROM Teg INNER JOIN  Teg_list  ON  Teg_list.teg_id = Teg.id WHERE product_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, ProductId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Teg teg = new Teg();
                teg.setId(resultSet.getLong(1));
                teg.setName(resultSet.getString(2));
                tegs.add(teg);
            }
        } catch (SQLException e) {
            LOGGER.warn(e);
            e.printStackTrace();
        }
        return tegs;
    }

    public ArrayList<Teg> getAllTeg(){
        ArrayList<Teg> tegs = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Teg";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Teg teg = new Teg();
                teg.setId(resultSet.getLong(1));
                teg.setName(resultSet.getString(2));
                tegs.add(teg);
            }
        } catch (SQLException e) {
            LOGGER.warn(e);
            e.printStackTrace();
        }
        return tegs;
    }

}
