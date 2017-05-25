package com.database.data.quiz.quiz;

import com.database.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wergin on 29-Apr-17.
 */
public class QuizRepository {
    public static List<Quiz> getQuizesByIdTest(int idTest) throws Exception{
        List<Quiz> quizList = new ArrayList<Quiz>();
        try{
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "select * from Quiz where idTest = " + idTest;
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                int idQuiz = Integer.parseInt(resultSet.getString("idQuiz"));
                String question = resultSet.getString("question");
                String variantA = resultSet.getString("variantA");
                String variantB = resultSet.getString("variantB");
                String variantC = resultSet.getString("variantC");
                String variantD = resultSet.getString("variantD");
                String rightVariant = resultSet.getString("rightVariant");
                VariantMapping variantMapping = new VariantMapping();
                Map<Variant, String> map = variantMapping.getVariants(variantA,variantB,variantC,variantD);
                Variant trueVariant = ConvertInEnumFrom.convertInEnumFromString(rightVariant);
                Quiz quiz = new Quiz(idQuiz, question,map, trueVariant,idTest);
                quizList.add(quiz);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return quizList;
    }

    public Map<Integer,Variant>  getQuizRightVariantByIdTest(int idTest) throws Exception{
        Map<Integer,Variant> map = new HashMap<Integer, Variant>();
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "select idQuiz,RightVariant from Quiz where idTest = " + idTest;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int idQuiz = Integer.parseInt(resultSet.getString("idQuiz"));
                String rightVariant = resultSet.getString("rightVariant");
                Variant trueVariant = ConvertInEnumFrom.convertInEnumFromString(rightVariant);
                map.put(idQuiz,trueVariant);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return map;
    }

    public Map<Variant,String> getVariantsByIdQuiz(int idQuiz) throws Exception{
        Map<Variant,String> map = null;
        try{
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "select variantA, variantB, variantC, variantD from Quiz where idQuiz = " + idQuiz;
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String variantA = resultSet.getString("variantA");
                String variantB = resultSet.getString("variantB");
                String variantC = resultSet.getString("variantC");
                String variantD = resultSet.getString("variantD");
                VariantMapping variantMapping = new VariantMapping();
                map = variantMapping.getVariants(variantA,variantB,variantC,variantD);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return map;
    }

    public Variant getRightVariantByIdQuiz(int idQuiz) throws Exception{
        Variant rightVariant = null;
        try{
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "select rightVariant from Quiz where idQuiz = " + idQuiz;
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String trueVariant = resultSet.getString("rightVariant");
                rightVariant = ConvertInEnumFrom.convertInEnumFromString(trueVariant);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return rightVariant;
    }

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
