package com.database.data;

import com.database.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by wergin on 30-Apr-17.
 */
public class RegistrationUpdate {
    public boolean updateRegistrationById(int idRegistration, String firstName, String lastName,String email, Enum<UserRule> userRuleEnum){
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "UPDATE Registration set firstName = '" + firstName +"', lastName = '"+ lastName+"', email = '"+ email +"',  idRule = " + RuleInput.setRule(userRuleEnum) + " where idRegistration = " + idRegistration;
            statement.executeUpdate(query);
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
