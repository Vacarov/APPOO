<%@ page import="com.database.data.RegistrationRepository" %>
<!-- SIDEBAR USER TITLE -->
<div class="profile-usertitle">
    <div class="profile-usertitle-name">
        <%
            RegistrationRepository registrationRepository = new RegistrationRepository();
            String emailFromSession = session.getAttribute("emailLogin").toString();
            int idRegistration = registrationRepository.findIdByEmail(emailFromSession);
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