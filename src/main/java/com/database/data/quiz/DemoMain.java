package com.database.data.quiz;

import com.database.data.quiz.course.Course;
import com.database.data.quiz.course.CourseInput;
import com.database.data.quiz.course.CourseRepository;
import com.database.data.quiz.quiz.QuizInput;
import com.database.data.quiz.test.Test;
import com.database.data.quiz.test.TestInput;
import com.database.data.quiz.test.TestRepository;

import java.util.Timer;


/**
 * Created by wergin on 29-Apr-17.
 */
public class DemoMain {
    public static void main(String[] args) {
        CourseRepository courseRepository = new CourseRepository();

        Course course = new Course(1,"Biology");
        CourseInput courseInput = new CourseInput();
        QuizInput quizInput = new QuizInput();
        try{
            System.out.println(TestRepository.getTestsByIdCourse(1));
             }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}