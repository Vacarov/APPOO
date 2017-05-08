package com.database.data.quiz.test;

import com.database.util.ConnectionConfiguration;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by wergin on 08-May-17.
 */
public class TestUpdate {
    public boolean updateTest(int idTest, String name, int time){
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "update Test set Name = '" + name + "', time = " + time + " where idTest = " + idTest;
            statement.executeUpdate(query);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        return true;
    }
}
