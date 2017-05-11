package com.servlet;

import com.database.data.ConverterRule;
import com.database.data.quiz.quiz.ConvertInEnumFrom;
import com.database.data.quiz.quiz.Quiz;
import com.database.data.quiz.quiz.QuizInput;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by wergin on 10-May-17.
 */
@WebServlet(name = "AddQuiz", urlPatterns = "/addQuiz")
public class AddQuiz extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            int idTest = Integer.parseInt(session.getAttribute("idTest").toString());
            String question = request.getParameter("question");
            String variantA = request.getParameter("variantA");
            String variantB = request.getParameter("variantB");
            String variantC = request.getParameter("variantC");
            String variantD = request.getParameter("variantD");
            String rightVariant = request.getParameter("rightVariant");
            QuizInput quizInput = new QuizInput();
            quizInput.insertNewQuiz(question,variantA,variantB,variantC,variantD, ConvertInEnumFrom.convertInEnumFromString(rightVariant),idTest);
            request.getRequestDispatcher("viewQuizzes.jsp").forward(request,response);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
