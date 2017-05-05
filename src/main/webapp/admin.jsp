<%@ page import="com.database.data.Registration" %>
<%@ page import="com.database.data.RegistrationRepository" %>
<%@ page import="com.database.data.RuleRepository" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<%String title = "Overview";%>
<%@include file="blocks/header.jsp" %>
<body>
<br><br><br><br>
<div class="container">
    <div class="row profile">
        <div class="col-md-3">
            <div class="profile-sidebar">
                <%@include file="blocks/sidebar-userpic.jsp" %>
                <%@include file="blocks/sidebar-profile.jsp" %>
                <%@include file="blocks/sidebar-buttons.jsp" %>
                <%@include file="blocks/siderbar-admin-menu.jsp" %>
            </div>
        </div>
        <div class="col-md-9">
            <div class="profile-content">
                <div class="table-responsive">
                    <table id="mytable" class="table table-bordred table-striped">
                        <thead>
                        <th><input type="checkbox" id="checkall"/></th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Access Role</th>
                        <th>Edit</th>
                        <th>Delete</th>
                        </thead>
                        <tbody>
                        <%
                            List<Registration> registrations = RegistrationRepository.getAllRegistrations();
                            RegistrationRepository registrationRepository1 = new RegistrationRepository();
                            RuleRepository ruleRepository = new RuleRepository();
                            for (Registration registration : registrations) {
                                int idRule = registrationRepository1.findRuleIdById(registrationRepository1.findIdByEmail(registration.getEmail()));
                                String nameRule = ruleRepository.findNameById(idRule);
                        %>
                        <tr>
                            <td><input type="checkbox" class="checkthis"/></td>
                            <td><%=registration.getFirstName()%>
                            </td>
                            <td><%=registration.getLastName()%>
                            </td>
                            <td><%=registration.getEmail()%>
                            </td>
                            <td><%=nameRule%>
                            </td>
                            <td>
                                <form action="/editRegistration" method="post">
                                    <p data-placement="top" data-toggle="tooltip" title="Edit">
                                        <input type="hidden" value="<%=registration.getIdRegistration()%>"
                                               name="idRegistration">
                                        <button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal"
                                                data-target="#edit" type="submit"><span class="glyphicon glyphicon-pencil"></span>
                                        </button>
                                    </p>
                                </form>
                            </td>
                            <td>
                                <form action="/delete" method="post">
                                    <p data-placement="top" data-toggle="tooltip" title="Delete">
                                        <input type="hidden" value="<%=registration.getIdRegistration()%>"
                                               name="idRegistration">
                                        <button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal"
                                                data-target="#delete" type="submit"><span
                                                class="glyphicon glyphicon-trash"></span>
                                        </button>
                                </form>
                                </p>
                            </td>
                        </tr>
                        <% }
                        %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<br>
<br>
</body>
</html>