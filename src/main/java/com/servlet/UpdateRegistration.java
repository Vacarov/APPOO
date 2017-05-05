package com.servlet;

import com.database.data.ConverterRule;
import com.database.data.RegistrationUpdate;
import com.database.data.UserRule;

import javax.jws.soap.SOAPBinding;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wergin on 30-Apr-17.
 */
@WebServlet(name = "UpdateRegistration", urlPatterns = "/updateRegistration")
public class UpdateRegistration extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idRegistration = Integer.parseInt(request.getParameter("idRegistration"));
        String fisrstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String rule = request.getParameter("role");
        ConverterRule converterRule = new ConverterRule();
        Enum<UserRule> userRule = converterRule.convertInEnumFromString(rule);
        RegistrationUpdate registrationUpdate = new RegistrationUpdate();
        registrationUpdate.updateRegistrationById(idRegistration,fisrstName,lastName,email, userRule);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin.jsp");
        rd.forward(request, response);
    }
}
