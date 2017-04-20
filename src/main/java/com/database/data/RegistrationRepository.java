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


    public static List<Registration> getAllRegistrations() {
        List<Registration> registrationList = new ArrayList<Registration>();
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "select firstName,lastName,email,password from Registration";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                Registration registration = new Registration(firstName, lastName, email, password);
                registrationList.add(registration);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return registrationList;
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

    public String findFirstNameById(int idRegistration){
        String firstName=null;
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "select firstName from Registration where idRegistration = " + idRegistration ;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                firstName = resultSet.getString("firstName");
            }
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return firstName;
    }

    public String findLastNameById(int idRegistration){
        String lastName=null;
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "select lastName from Registration where idRegistration = " + idRegistration ;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                lastName = resultSet.getString("lastName");
            }
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return lastName;
    }

    public int findRuleIdById(int idRegistration){
        int idRule = -1;
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "select idRule from Registration where idRegistration = " + idRegistration ;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                idRule = resultSet.getInt("idRule");
            }
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return idRule;
    }

    public String findRuleNameByIdRegistration(int idRegistration){
        String nameRule = null;
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "select Rule.Name from Rule left join Registration on Registration.IDRULE = Rule.IDRULE where Registration.idRegistration = " + idRegistration ;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                nameRule = resultSet.getString("name");
            }
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return nameRule;
    }

    public int findIdByEmail(String email) {
        int idRegistration = 0;
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "select idRegistration from Registration where EMAIL = '" + email + "'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                idRegistration = resultSet.getInt("idRegistration");
            }
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return idRegistration;
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