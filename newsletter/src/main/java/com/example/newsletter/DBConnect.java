package com.example.newsletter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Essa classe é responsável por conectar com nosso banco de dados
public class DBConnect {
    private Connection connection;

    public Connection startConnection() {
        String url = "jdbc:mysql://localhost:3306/newsletter?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "";

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }
    public void endConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
