package com.servlet;

import com.database.data.RegistrationDelete;

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
@WebServlet(name = "DeleteRegistration", urlPatterns = "/delete")
public class DeleteRegistration extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int idRegistration = Integer.parseInt(req.getParameter("idRegistration"));
            RegistrationDelete registrationDelete = new RegistrationDelete();
            registrationDelete.deleteRegistrationById(idRegistration);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin.jsp");
            rd.forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}