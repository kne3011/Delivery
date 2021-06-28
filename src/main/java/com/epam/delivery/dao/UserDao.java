package com.epam.delivery.dao;

import com.epam.delivery.database.connection.ConnectionPool;
import com.epam.delivery.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private static ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static Connection connection = connectionPool.takeConnection();

    public User getUserWithEmail(String email) {
        User user = null;
        try {
            String sql = "SELECT * FROM User WHERE email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(1));
                user.setEmail(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setName(resultSet.getString(4));
                user.setAddress(resultSet.getString(5));
                user.setStatus(resultSet.getInt(6));
                return user;
            }
        } catch (SQLException e) {
            LOGGER.warn(e);
            e.printStackTrace();
        }
        return user;
    }

    public String registerUser(String email, String password, String name, String address) {
        String check = "We have already this email";
        try {
            User user = getUserWithEmail(email);
            if (user == null) {
                long userStatus = 1;// for normal user
                String sql = "INSERT INTO User values(null, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, name);
                preparedStatement.setString(4, address);
                preparedStatement.setLong(5, userStatus);
                preparedStatement.execute();
                check = "Success";
            }
        } catch (SQLException e) {
            LOGGER.warn(e);
            e.printStackTrace();
        }
        return check;
    }

    public User Login(String email, String password) {
        User user = getUserWithEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }
}
