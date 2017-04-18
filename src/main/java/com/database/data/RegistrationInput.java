package com.database.data;


import com.database.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by wergin on 14-Mar-17.
 */
public class RegistrationInput {
    public boolean insertNewRegistration(Registration registration) {
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "insert into Registration (IDREGISTRATION, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, IDRULE)VALUES(" + putValidId() + ",'" + registration.getFirstName() + "','" + registration.getLastName() + "','" + registration.getEmail() + "','" + registration.getPassword() + "'," + RuleInput.setRule(UserRule.GUEST) + ")";
            statement.executeUpdate(query);
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public Integer putValidId() {
        RegistrationRepository registrationRepository = new RegistrationRepository();
        return (registrationRepository.findMaximalId() + 1);
    }
}
