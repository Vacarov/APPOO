package com.database.data.quiz.quiz;

import com.database.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by wergin on 10-May-17.
 */
public class QuizUpdate {
    public boolean insertNewQuiz(int idQuiz,String question, String variantA, String variantB,String variantC, String variantD,Variant rightVariant){
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "update Quiz set QUESTION = '"+ question +"', VARIANTA = '"+variantA+"',VARIANTB = '"+variantB+"',VARIANTC = '"+variantC+"',VARIANTD = '"+variantD+"',RIGHTVARIANT = "+ rightVariant +" + where idQuiz = " + idQuiz;
                    statement.executeUpdate(query);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        return true;
    }
}
