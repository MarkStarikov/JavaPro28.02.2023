package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {

    private static Connection connection;
    private static final String name = "postgres";
    private static final String password = "voluntary";

    public static Connection getConnection()  {

        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", name, password);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot create connection ", e);
        }

        return connection;
    }

}
