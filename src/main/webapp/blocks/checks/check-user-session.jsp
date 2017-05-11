<%
    if (session.getAttribute("idRegistration") == null) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>