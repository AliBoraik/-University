package ru.itis.models;

import ru.itis.annotations.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DataBase {
    private static Connection connection;

    public DataBase() {
        connection = getConnection();
    }

    public Connection getConnection() {

        if (connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://127.0.0.1:5432/testentity";
                connection = DriverManager.getConnection(url,"postgres","asas1212");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }

}
