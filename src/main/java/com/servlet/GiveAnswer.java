package com.servlet;

import com.database.data.quiz.quiz.ConvertInEnumFrom;
import com.database.data.quiz.quiz.QuizRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wergin on 09-May-17.
 */
@WebServlet(name = "GiveAnswer", urlPatterns = "/giveAnswer")
public class GiveAnswer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String answer = request.getParameter("q_answer");
            int idQuiz = Integer.parseInt(request.getParameter("idQuiz"));
            QuizRepository quizRepository = new QuizRepository();
            String resp;
            if (ConvertInEnumFrom.convertInEnumFromString(answer).equals(quizRepository.getRightVariantByIdQuiz(idQuiz))) {
                resp = "Correct!";
            } else resp = "Wrong!";
            request.setAttribute("resp", resp);
            System.out.println(resp);
            request.getRequestDispatcher("test.jsp").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}