package com.ims.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBConnection {
    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties dbProperties = getProperties();
                String dbUrl = dbProperties.getProperty("dbUrl");
                conn = DriverManager.getConnection(dbUrl, dbProperties);
            } catch (SQLException e) {
                // TODO: Handle error
                System.out.println("error: " + e.getMessage());
            }
        }

        return conn;
    }

    public static Properties getProperties() {
        try (FileInputStream stream = new FileInputStream("database.properties")) {
            Properties properties = new Properties();
            properties.load(stream);
            return properties;
        } catch (IOException e) {
            // TODO: Handle error
            System.out.println("error: " + e.getMessage());
        }

        return null;
    }

    public static void closeStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                // TODO: Handle error
                System.out.println("error: " + e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet result) {
        if (result != null) {
            try {
                result.close();
            } catch (SQLException e) {
                // TODO: Handle error
                System.out.println("error: " + e.getMessage());
            }
        }
    }
}
