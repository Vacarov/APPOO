package com.servlet;

import com.database.data.Registration;
import com.database.data.RegistrationRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wergin on 29-Apr-17.
 */
@WebServlet(name = "EditRegistration", urlPatterns = "/editRegistration")
public class EditRegistration extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idRegistration = Integer.parseInt(request.getParameter("idRegistration"));
        RegistrationRepository registrationRepository = new RegistrationRepository();
        Registration registration = registrationRepository.getDataRegistrationById(idRegistration);
        String rule = registrationRepository.findRuleNameByIdRegistration(idRegistration);
        request.setAttribute("idRegistration", idRegistration);
        request.setAttribute("userData",registration);
        request.setAttribute("userRule",rule);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/editRegistration.jsp");
        rd.forward(request, response);
    }
}
