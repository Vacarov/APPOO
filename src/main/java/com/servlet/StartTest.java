package com.servlet;

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
@WebServlet(name = "StartTest", urlPatterns = "/startTest")
public class StartTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idTest = Integer.parseInt(request.getParameter("idTest"));
        HttpSession session = request.getSession();
        session.setAttribute("idTest", idTest);
        request.getRequestDispatcher("test.jsp").forward(request,response);
    }
}