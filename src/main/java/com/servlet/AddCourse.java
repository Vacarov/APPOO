package com.servlet;

import com.database.data.quiz.course.CourseInput;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wergin on 06-May-17.
 */
@WebServlet(name = "AddCourse", urlPatterns = "/addCourse")
public class AddCourse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("courseName");
            CourseInput courseInput = new CourseInput();
            courseInput.insertCourse(name);
            request.getRequestDispatcher("teacher.jsp").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
