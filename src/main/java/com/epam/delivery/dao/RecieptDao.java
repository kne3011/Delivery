package com.epam.delivery.dao;

import com.epam.delivery.database.connection.ConnectionPool;
import com.epam.delivery.entity.Reciept;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class RecieptDao {
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private static ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static Connection connection = connectionPool.takeConnection();

    public long createReciept(String type, Date time, int allPrices, long user_id){
        long check = -1;
        try {
            String sql = "INSERT INTO Reciept values(null, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql,  Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, type);
            preparedStatement.setDate(2, time);
            preparedStatement.setInt(3, allPrices);
            preparedStatement.setLong(4, user_id);
            preparedStatement.execute();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                check = generatedKeys.getLong(1);
            }
        } catch (SQLException e) {
            LOGGER.warn(e);
            e.printStackTrace();
        }
        return check;
    }

    public ArrayList<Reciept> getHistoryOfUser(long user_id){
        ArrayList<Reciept> reciepts = new ArrayList<>();
        try {
            String sql = "Select * FROM Reciept WHERE user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Reciept reciept = new Reciept();
                reciept.setId(resultSet.getLong(1));
                reciept.setType(resultSet.getString(2));
                reciept.setTime(resultSet.getDate(3));
                reciept.setAllPrice(resultSet.getInt(4));
                reciept.setUser_id(resultSet.getLong(5));
                reciepts.add(reciept);
            }
        } catch (SQLException e) {
            LOGGER.warn(e);
            e.printStackTrace();
        }
        return reciepts;
    }
}
