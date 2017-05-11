package com.database.data.quiz;

import com.database.data.quiz.course.Course;
import com.database.data.quiz.course.CourseInput;
import com.database.data.quiz.course.CourseRepository;
import com.database.data.quiz.quiz.Quiz;
import com.database.data.quiz.quiz.QuizInput;
import com.database.data.quiz.quiz.Variant;
import com.database.data.quiz.test.Test;
import com.database.data.quiz.test.TestInput;
import com.database.data.quiz.test.TestRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;


/**
 * Created by wergin on 29-Apr-17.
 */
public class DemoMain {
    public static void main(String[] args) {
        try{
                QuizInput quizInput = new QuizInput();
                quizInput.insertNewQuiz("De ce?", "deoarece",  "fiindca", "nustiu", "mne stidno", Variant.A, 1);
                quizInput.insertNewQuiz("Serios?", "haha",  "fiindca", "nustiu", "aga", Variant.D, 1);
             }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}