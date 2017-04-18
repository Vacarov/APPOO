package com.database.data;

import com.database.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by wergin on 16-Apr-17.
 */
public class RuleUpdate {
    public void updateRuleIntoRegistration(int idRegistration, Enum<UserRule> userRuleEnum) {
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "UPDATE Registration set idRule = " + RuleInput.setRule(userRuleEnum) + " where idRegistration = " + idRegistration;
            statement.executeUpdate(query);
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
