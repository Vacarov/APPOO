package com.servlet;

import com.database.data.quiz.quiz.Answer;
import com.database.data.quiz.quiz.ConvertInEnumFrom;
import com.database.data.quiz.quiz.QuizRepository;
import com.database.data.quiz.quiz.Variant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by wergin on 09-May-17.
 */
@WebServlet(name = "GiveAnswer", urlPatterns = "/giveAnswer")
public class GiveAnswer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            int idTest = Integer.parseInt(session.getAttribute("idTest").toString());
            QuizRepository quizRepository = new QuizRepository();
            Map<Integer, Variant> rightResponses = quizRepository.getQuizRightVariantByIdTest(idTest);
            request.setAttribute("rightResponses", rightResponses);
            Set<Integer> idsQuizzes = rightResponses.keySet();
            Map<Integer, Variant> answer = new HashMap<Integer, Variant>();
            for (Integer idQuiz : idsQuizzes) {
                if (request.getParameter("q_answer" + idQuiz) != null) {
                    String q_answer = request.getParameter("q_answer" + idQuiz);
                    Variant variant = ConvertInEnumFrom.convertInEnumFromString(q_answer);
                    answer.put(idQuiz, variant);
                }
            }
            Answer wrongResponses = new Answer();
            Answer ans = new Answer();
            Map<Integer, String> q_ckecks = ans.getQuizzesResult(rightResponses, answer);
            request.setAttribute("wrongResponses",wrongResponses.getWrongQuizzesResult(rightResponses,answer));
            request.setAttribute("q_checks", q_ckecks);
            request.getRequestDispatcher("resultTest.jsp").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}