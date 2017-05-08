package com.servlet;

import com.database.data.quiz.test.Test;
import com.database.data.quiz.test.TestUpdate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wergin on 08-May-17.
 */
@WebServlet(name = "UpdateTest", urlPatterns = "/updateTest")
public class UpdateTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TestUpdate testUpdate = new TestUpdate();
        int idTest = Integer.parseInt(request.getParameter("idTest"));
        String name = request.getParameter("testName");
        int time = Integer.parseInt(request.getParameter("testTime"));
        try {
            testUpdate.updateTest(idTest,name,time);
            request.getRequestDispatcher("testList.jsp").forward(request,response);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
