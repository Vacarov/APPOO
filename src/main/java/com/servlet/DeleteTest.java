package com.servlet;

import com.database.data.quiz.test.TestDelete;
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
@WebServlet(name = "DeleteTest", urlPatterns = "/deleteTest")
public class DeleteTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idTest = Integer.parseInt(request.getParameter("idTest"));
        TestDelete testDelete = new TestDelete();
        testDelete.deleteTestById(idTest);
        request.getRequestDispatcher("testList.jsp").forward(request,response);
    }
}
