package com.database.data.quiz.test;

import com.database.data.quiz.course.Course;
import com.database.util.ConnectionConfiguration;

import javax.management.Query;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wergin on 29-Apr-17.
 */
public class TestRepository {
    public static List<Test> getTestsByIdCourse(int idCourse) throws Exception{
        List<Test> testList = new ArrayList<Test>();
        try{
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "select * from Test where idObject = " + idCourse;
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                int idTest = Integer.parseInt(resultSet.getString("idTest"));
                String name = resultSet.getString("name");
                int time = Integer.parseInt(resultSet.getString("time"));
                int idTeacher = Integer.parseInt(resultSet.getString("idTeacher"));
                TestRepository testRepository = new TestRepository();
                TestRepository testRepository1 = new TestRepository();
                Test test = new Test(idTest,name,time,testRepository.getFullNameTeacherByIdTeacher(idTeacher),testRepository1.findCourseByIdCourse(idCourse));
                testList.add(test);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return testList;
    }

    public Test findTestByIdTest(int idTest){
        Test test= null;
        try{
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "select * from Test where idTest = " + idTest;
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String name = resultSet.getString("name");
                int time = Integer.parseInt(resultSet.getString("time"));
                int idTeacher = Integer.parseInt(resultSet.getString("idTeacher"));
                TestRepository testRepository = new TestRepository();
                test = new Test(idTest,name,time,testRepository.getFullNameTeacherByIdTeacher(idTeacher));
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return test;
    }

    public Course findCourseByIdCourse(int idCourse){
        Course course = null;
        try{
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "select Object.Name from Test,Object where Object.idObject = " + idCourse + " and " + " Test.idObject = " + idCourse;
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String name = resultSet.getString(1);
                course = new Course(idCourse,name);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return course;
    }

    public String getFullNameTeacherByIdTeacher(int idTeacher){
        String name = null;
        try{
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "select Registration.firstName, Registration.lastName from Test,Registration where Registration.idRegistration = " + idTeacher + " and " + " Test.idTeacher = " + idTeacher;
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String firstName = resultSet.getString(1);
                String lastName = resultSet.getString(2);
                name = firstName + " " + lastName;
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return name;
    }

    public Integer findMaximalIdTest(){
        Connection connection = ConnectionConfiguration.getDBConnection();
        Integer maximalId = null;
        try {
            Statement statement = connection.createStatement();
            String query = "select MAX(idTest) AS MaximalId from Test";
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
