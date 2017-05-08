package com.database.data.quiz.course;

import com.database.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by wergin on 23-Apr-17.
 */
public class CourseInput {
    public boolean insertCourse(String name) throws Exception{
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "insert into Object(idObject, Name)values(" + putValidIdCourse() + ",'" + name + "')";
            statement.executeUpdate(query);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        return true;
    }

    public Integer putValidIdCourse(){
        CourseRepository courseRepository = new CourseRepository();
        return courseRepository.findMaximalIdCourse()+1;
    }
}