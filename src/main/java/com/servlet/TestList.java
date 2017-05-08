package com.servlet;

import com.database.data.quiz.test.TestRepository;

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
@WebServlet(name = "TestList", urlPatterns = "/testList")
public class TestList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idCourse = Integer.parseInt(request.getParameter("idCourse"));
            HttpSession session = request.getSession();
            session.setAttribute("idCourse", idCourse);
            request.getRequestDispatcher("testList.jsp").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}