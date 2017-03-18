package com.servlet;

import com.database.data.AuthetificationService;
import com.database.data.Registration;
import com.database.data.RegistrationInput;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wergin on 14-Mar-17.
 */
@WebServlet(name = "Register", urlPatterns = "/Register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Registration registration = new Registration(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("email"), request.getParameter("password"));
        AuthetificationService authetificationService = new AuthetificationService();
        String confirmPassword = request.getParameter("confirmPassword");
        if (!authetificationService.existEmail(registration.getEmail()) && registration.getPassword().equals(confirmPassword)) {
            RegistrationInput registrationInput = new RegistrationInput();
            registrationInput.insertNewRegistration(registration);
            response.sendRedirect("index.jsp");
        }
    }
}
