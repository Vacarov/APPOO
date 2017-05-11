package com.database.data.quiz.quiz;

import com.database.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by wergin on 29-Apr-17.
 */
public class QuizInput {
    public boolean insertNewQuiz(String question, String variantA, String variantB,String variantC, String variantD,Variant rightVariant, int idTest){
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "insert into Quiz(IDQUIZ,QUESTION,VARIANTA,VARIANTB,VARIANTC,VARIANTD,RIGHTVARIANT,IDTEST)values( "+ putValidIdQuiz() + ",'" + question + "','" + variantA + "','" + variantB+ "','" + variantC + "','" + variantD + "','" + rightVariant + "', "+ idTest + ")" ;
            statement.executeUpdate(query);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        return true;
    }

    public Integer putValidIdQuiz(){
        QuizRepository quizRepository = new QuizRepository();
        return quizRepository.findMaximalIdQuiz()+1;
    }
}