package com.servlet;

import com.database.data.quiz.course.CourseUpdate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wergin on 06-May-17.
 */
@WebServlet(name = "UpdateCourse", urlPatterns = "/updateCourse")
public class UpdateCourse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseUpdate courseUpdate = new CourseUpdate();
        int idCourse = Integer.parseInt(request.getParameter("idCourse"));
        try {
            String name = request.getParameter("newCourseName");
            courseUpdate.updateCourse(idCourse, name);
            request.getRequestDispatcher("teacher.jsp").forward(request,response);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
