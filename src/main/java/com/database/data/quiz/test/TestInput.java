package com.database.data.quiz.test;

import com.database.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by wergin on 29-Apr-17.
 */
public class TestInput {
    public boolean insertNewTest(String name,int time, int idTeacher, int idCourse){
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "insert into Test(IDTEST,NAME , TIME ,IDTEACHER,IDObject)values( "+ putValidId() + ",'" + name + "'," + time + "," + idTeacher + "," + idCourse + ")" ;
            statement.executeUpdate(query);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        return true;
    }
    public Integer putValidId(){
        TestRepository testRepository = new TestRepository();
        return testRepository.findMaximalIdTest()+1;
    }
}