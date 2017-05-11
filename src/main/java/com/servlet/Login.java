package com.servlet;

import com.database.data.AuthetificationService;
import com.database.data.RegistrationRepository;
import com.database.data.RuleRepository;
import com.database.data.UserRule;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by wergin on 03-Mar-17.
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            AuthetificationService authetificationService = new AuthetificationService();
            if (authetificationService.authetificate(email, password).booleanValue()) {
                HttpSession session = request.getSession();
                RegistrationRepository registrationRepository = new RegistrationRepository();
                int idRegistration = registrationRepository.findIdByEmail(email);
                session.setAttribute("idRegistration", idRegistration);
                response.setContentType("text/html");
                RuleRepository ruleRepository = new RuleRepository();
                if (ruleRepository.isAdmin(idRegistration) == true)
                    request.getRequestDispatcher("admin.jsp").forward(request,response);
                else if (ruleRepository.isTeacher(idRegistration) == true)
                    request.getRequestDispatcher("teacher.jsp").forward(request, response);
                else request.getRequestDispatcher("student.jsp").forward(request,response);
            } else request.getRequestDispatcher("index.jsp").forward(request,response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}