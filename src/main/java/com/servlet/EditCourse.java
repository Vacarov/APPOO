package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wergin on 06-May-17.
 */
@WebServlet(name = "EditCourse", urlPatterns = "/editCourse")
public class EditCourse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCourse = Integer.parseInt(request.getParameter("idCourse"));
        request.setAttribute("idCourse",idCourse);
        request.getRequestDispatcher("editCourse.jsp").forward(request,response);
    }
}
