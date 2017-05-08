package com.servlet;

import com.database.data.quiz.course.CourseInput;
import com.database.data.quiz.test.Test;
import com.database.data.quiz.test.TestInput;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by wergin on 07-May-17.
 */
@WebServlet(name = "AddTest", urlPatterns = "/addTest")
public class AddTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            int idCourse = Integer.parseInt(session.getAttribute("idCourse").toString());
            HttpSession idTeacherSession = request.getSession();
            int idTeacher = Integer.parseInt(idTeacherSession.getAttribute("idRegistration").toString());
            String name = request.getParameter("testName");
            int time = Integer.parseInt(request.getParameter("testTime"));
            TestInput testInput = new TestInput();
            testInput.insertNewTest(name,time,idTeacher,idCourse);
            request.getRequestDispatcher("/testList.jsp").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}