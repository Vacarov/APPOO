package com.database.data;


import com.database.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wergin on 11-Mar-17.
 */
public class RegistrationRepository {

    public static List<String> getAllEmails() {
        List<String> emailsList = new ArrayList();
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement stm = connection.createStatement();
            String query = "select EMAIL from Registration";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String email = rs.getString("email");
                emailsList.add(email);
            }
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return emailsList;
    }

    public String findPasswordByEmail(String email) {
        String password = null;
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "select PASSWORD from Registration where EMAIL = '" + email + "'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                password = resultSet.getString("password");
            }
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return password;
    }

    public Integer findMaximalId() {
        Connection connection = ConnectionConfiguration.getDBConnection();
        Integer maximalId = null;
        try {
            Statement statement = connection.createStatement();
            String query = "select MAX(idRegistration) AS MaximalId from Registration";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                maximalId = resultSet.getInt("MaximalId");
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maximalId;
    }
}