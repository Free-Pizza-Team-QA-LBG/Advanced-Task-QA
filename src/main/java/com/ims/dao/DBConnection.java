package com.ims.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBConnection {
    private static Connection conn = null;

    /**
     * Gets the active connection to the database if available, otherwise creates and returns a new connection.
     *
     * @return The Connection object
     */
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties dbProperties = getProperties();
                String dbUrl = dbProperties.getProperty("url");
                conn = DriverManager.getConnection(dbUrl, dbProperties);
            } catch (SQLException e) {
                // TODO: Handle error
                System.out.println("error: " + e.getMessage());
            }
        }

        return conn;
    }

    /**
     * Retrieves the database credentials from the properties file.
     *
     * @return The database credentials as a Properties object
     */
    private static Properties getProperties() {
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

    /**
     * Closes a PreparedStatement object if non-null.
     *
     * @param stmt The statement to be closed.
     */
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

    /**
     * Closes a ResultSet object if non-null.
     *
     * @param result The result set to be closed.
     */
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
