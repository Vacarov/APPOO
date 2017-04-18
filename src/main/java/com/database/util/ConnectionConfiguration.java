package com.database.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by wergin on 10-Mar-17.
 */
public class ConnectionConfiguration {
    private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "system";
    private static final String PASSWORD = "we092061";

    public static Connection getDBConnection() {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}