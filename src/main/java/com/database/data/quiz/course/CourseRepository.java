package com.database.data.quiz.course;

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
public class CourseRepository {

    public static List<Course> getAllCourses() throws Exception{
        List<Course> courseList = new ArrayList<Course>();
        try{
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = " select * from Object ";
            ResultSet resultSet= statement.executeQuery(query);
            while (resultSet.next()){
                int idCourse = Integer.parseInt(resultSet.getString("idObject"));
                String name = resultSet.getString("name");
                courseList.add(new Course(idCourse,name));
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return courseList;
    }

    public String findNameById(int idCourse){
        String name = null;
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "select Name from Object where idObject = " + idCourse ;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                name = resultSet.getString("Name");
            }
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return name;
    }

    public Integer findMaximalIdCourse(){
        Connection connection = ConnectionConfiguration.getDBConnection();
        Integer maximalId = null;
        try {
            Statement statement = connection.createStatement();
            String query = "select MAX(idObject) AS MaximalId from Object";
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