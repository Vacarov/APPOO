package com.database.data.quiz;

import com.database.data.quiz.course.Course;
import com.database.data.quiz.course.CourseInput;
import com.database.data.quiz.course.CourseRepository;
import com.database.data.quiz.quiz.QuizInput;
import com.database.data.quiz.test.Test;
import com.database.data.quiz.test.TestInput;

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
//            Timer timer = new Timer();
//            timer.schedule(new SayHello(),0,1000);

            Test test = new Test(1,"Cjimia biorganica",20,"asd",course);
            TestInput testInput =  new TestInput();
            testInput.insertNewTest(test);
             }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}