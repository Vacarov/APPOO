package com.database.data.quiz.quiz;

import com.database.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by wergin on 29-Apr-17.
 */
public class QuizRepository {
    public Integer findMaximalIdQuiz(){
        Connection connection = ConnectionConfiguration.getDBConnection();
        Integer maximalId = null;
        try {
            Statement statement = connection.createStatement();
            String query = "select MAX(idQuiz) AS MaximalId from Quiz";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                maximalId = resultSet.getInt("MaximalId");
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maximalId;
    }
}
