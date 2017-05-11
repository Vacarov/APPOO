package com.database.data.quiz.quiz;

import com.database.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by wergin on 10-May-17.
 */
public class QuizDelete {
    public boolean deleteQuizById(int idQuiz) {
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "delete from Quiz where idQuiz = " + idQuiz;
            statement.executeQuery(query);
        }catch (Exception e){
            throw new RuntimeException();
        }
        return true;
    }

    public boolean deleteAllQuizzesByIdTest(int idTest) {
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "delete from Quiz where idTest = " + idTest;
            statement.executeQuery(query);
        }catch (Exception e){
            throw new RuntimeException();
        }
        return true;
    }
}
