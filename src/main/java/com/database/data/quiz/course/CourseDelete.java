package com.database.data.quiz.course;

import com.database.data.quiz.test.Test;
import com.database.data.quiz.test.TestDelete;
import com.database.data.quiz.test.TestRepository;
import com.database.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by wergin on 06-May-17.
 */
public class CourseDelete {
    public boolean deleteCourseById(int idCourse) throws Exception{
        try {
            TestDelete testDelete = new TestDelete();
            testDelete.deleteAllTestByIdCourse(idCourse);
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "delete from Object where idObject = " + idCourse ;
            statement.executeQuery(query);
        }catch (Exception e){
            throw new RuntimeException();
        }
        return true;
    }
}