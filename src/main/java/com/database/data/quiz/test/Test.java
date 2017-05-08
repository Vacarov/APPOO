package com.database.data.quiz.test;

import com.database.data.quiz.course.Course;
import com.database.data.quiz.quiz.Quiz;

import java.util.List;

/**
 * Created by wergin on 23-Apr-17.
 */
public class Test {
    private int idTest;
    private String name;
    private int time;
    private String author;
    private Course course;
    private static List<Quiz> quizList = null;

    public Test(int idTest, String name, int time, String author, Course course) {
        this.idTest = idTest;
        this.name = name;
        this.time = time;
        this.author = author;
        this.course = course;
    }

    public Test(int idTest, String name, int time, String author) {
        this.idTest = idTest;
        this.name = name;
        this.time = time;
        this.author = author;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public static List<Quiz> getQuizList() {
        return quizList;
    }

    public static void setQuizList(List<Quiz> quizList) {
        Test.quizList = quizList;
    }
}