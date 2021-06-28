package com.epam.delivery.dao;

import com.epam.delivery.database.connection.ConnectionPool;
import com.epam.delivery.entity.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private static ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static Connection connection = connectionPool.takeConnection();

    public String createProduct(String name, long type_id, String description, String photo_link, int price){
        String check = "Product do not added";
        try {
            String sql = "INSERT INTO Product values(null, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, type_id);
            preparedStatement.setString(3, description);
            preparedStatement.setString(4, photo_link);
            preparedStatement.setInt(5, price);
            preparedStatement.execute();
            check = "Success";
        } catch (SQLException e) {
            LOGGER.warn(e);
            e.printStackTrace();
        }
        return check;
    }

    public String changeProduct(long id, String name, long type_id, String description, String photo_link, int price){
        String check = "Product do not change";
        try {
            String sql = "UPDATE Product SET name = ?, type_id = ?, description = ?, photo_link = ?, price = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, type_id);
            preparedStatement.setString(3, description);
            preparedStatement.setString(4, photo_link);
            preparedStatement.setInt(5, price);
            preparedStatement.setLong(6, id);
            preparedStatement.execute();
            check = "Success";
        } catch (SQLException e) {
            LOGGER.warn(e);
            e.printStackTrace();
        }
        return check;
    }

    public ArrayList<Product> getAllProduct(){
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getLong(1));
                product.setName(resultSet.getString(2));
                product.setType_id(resultSet.getLong(3));
                product.setDescription(resultSet.getString(4));
                product.setPhoto_link(resultSet.getString(5));
                product.setPrice(resultSet.getInt(6));
                products.add(product);
            }
        } catch (SQLException e) {
            LOGGER.warn(e);
            e.printStackTrace();
        }
        return products;
    }

    public ArrayList<Product> getAllProductWithTeg(Long TegId){
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT Product.id, Product.name, Product.type_id, Product.description, Product.photo_link, Product.price FROM Product INNER JOIN  Teg_list  ON  Teg_list.product_id = Product.id WHERE teg_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, TegId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getLong(1));
                product.setName(resultSet.getString(2));
                product.setType_id(resultSet.getLong(3));
                product.setDescription(resultSet.getString(4));
                product.setPhoto_link(resultSet.getString(5));
                product.setPrice(resultSet.getInt(6));
                products.add(product);
            }
        } catch (SQLException e) {
            LOGGER.warn(e);
            e.printStackTrace();
        }
        return products;
    }

    public String deleteProduct(Long ProductId){
        String check = "Product do not delete";
        try {
            String sql = "DELETE FROM Product WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, ProductId);
            preparedStatement.execute();
            check = "Success";
        } catch (SQLException e) {
            LOGGER.warn(e);
            e.printStackTrace();
        }
        return check;
    }

    public Product getProduct(Long id){
        Product product = null;
        try {
            String sql = "SELECT * FROM Product WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                product = new Product();
                product.setId(resultSet.getLong(1));
                product.setName(resultSet.getString(2));
                product.setType_id(resultSet.getLong(3));
                product.setDescription(resultSet.getString(4));
                product.setPhoto_link(resultSet.getString(5));
                product.setPrice(resultSet.getInt(6));
            }
        } catch (SQLException e) {
            LOGGER.warn(e);
            e.printStackTrace();
        }
        return product;
    }
}
