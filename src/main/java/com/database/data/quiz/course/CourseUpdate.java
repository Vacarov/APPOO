package com.database.data.quiz.course;

import com.database.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by wergin on 06-May-17.
 */
public class CourseUpdate {
    public boolean updateCourse(int idCourse, String name) throws Exception{
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "update Object set Name = '" + name + "' where idObject = " + idCourse;
            statement.executeUpdate(query);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        return true;
    }
}
