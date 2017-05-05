package com.database.data;

import com.database.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by wergin on 29-Apr-17.
 */
public class RegistrationDelete {
    public boolean deleteRegistrationById(int idRegistration) throws Exception{
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "delete from Registration where idRegistration = " + idRegistration;
            statement.executeQuery(query);
        }catch (Exception e){
            throw new RuntimeException();
        }
        return true;
    }
}
