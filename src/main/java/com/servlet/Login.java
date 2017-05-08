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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        AuthetificationService authetificationService = new AuthetificationService();
        if (authetificationService.authetificate(email, password).booleanValue()) {
            HttpSession session = request.getSession();
            RegistrationRepository registrationRepository = new RegistrationRepository();
            session.setAttribute("idRegistration", registrationRepository.findIdByEmail(email));
            response.setContentType("text/html");
            RuleRepository ruleRepository = new RuleRepository();
            if (ruleRepository.findUserRule(email).equals(UserRule.ADMIN.toString().toLowerCase()))
            response.sendRedirect("admin.jsp");
            else if (ruleRepository.findUserRule(email).equals(UserRule.TEACHER.toString().toLowerCase()))
                response.sendRedirect("teacher.jsp");
            else response.sendRedirect("student.jsp");
        } else response.sendRedirect("index.jsp");
    }
}