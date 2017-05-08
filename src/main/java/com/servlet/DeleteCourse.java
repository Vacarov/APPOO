package com.servlet;

import com.database.data.Registration;
import com.database.data.quiz.course.CourseDelete;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wergin on 06-May-17.
 */
@WebServlet(name = "DeleteCourse", urlPatterns = "/deleteCourse")
public class DeleteCourse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idCourse = Integer.parseInt(request.getParameter("idCourse"));
            CourseDelete courseDelete = new CourseDelete();
            courseDelete.deleteCourseById(idCourse);
            request.getRequestDispatcher("teacher.jsp").forward(request,response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}