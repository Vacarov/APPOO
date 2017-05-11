package com.servlet;

import com.database.data.quiz.quiz.QuizDelete;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wergin on 10-May-17.
 */
@WebServlet(name = "DeleteQuiz", urlPatterns = "/deleteQuiz")
public class DeleteQuiz extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idQuiz = Integer.parseInt(request.getParameter("idQuiz"));
        QuizDelete quizDelete = new QuizDelete();
        quizDelete.deleteQuizById(idQuiz);
        request.getRequestDispatcher("viewQuizzes.jsp").forward(request,response);
    }
}