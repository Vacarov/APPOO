package com.database.data.quiz.test;

import com.database.data.quiz.quiz.QuizDelete;
import com.database.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by wergin on 08-May-17.
 */
public class TestDelete {
    public boolean deleteTestById(int idTest) {
        try {
            QuizDelete quizDelete = new QuizDelete();
            quizDelete.deleteAllQuizzesByIdTest(idTest);
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "delete from Test where idTest = " + idTest;
            statement.executeQuery(query);
        }catch (Exception e){
            throw new RuntimeException();
        }
        return true;
    }

    public boolean deleteAllTestByIdCourse(int idCourse) {
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "delete from Test where idObject = " + idCourse;
            statement.executeQuery(query);
        }catch (Exception e){
            throw new RuntimeException();
        }
        return true;
    }
}
