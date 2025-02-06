package com.example.petshop.Data.Database;

import java.sql.*;

public class DbContext {
    private final String url;
    private final String username;
    private final String password;
    private Connection connection;

    public DbContext(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, username, password);
        }
    }

    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }


}