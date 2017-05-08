<%@ page import="com.database.data.RegistrationRepository" %>
<!-- SIDEBAR USER TITLE -->
<div class="profile-usertitle">
    <div class="profile-usertitle-name">
        <%
            RegistrationRepository registrationRepository = new RegistrationRepository();
            int idRegistration = Integer.parseInt(session.getAttribute("idRegistration").toString());
            String firstName = registrationRepository.findFirstNameById(idRegistration);
            String lastName = registrationRepository.findLastNameById(idRegistration);
            String role = registrationRepository.findRuleNameByIdRegistration(idRegistration);
        %>
        <%=firstName + " " + lastName%>
    </div>
    <div class="profile-usertitle-job">
        <%=role%>
    </div>
</div>
<!-- END SIDEBAR USER TITLE -->