<%@ page import="com.database.data.Registration" %>
<%@ page import="com.database.data.UserRule" %>
<!DOCTYPE html>
<html lang="en">
<%String title = "edit registration";%>
<%@include file="blocks/header.jsp"%>
<%@include file="blocks/checks/check-user-session.jsp" %>
<body>
<br><br><br><br>
<%Registration registration = (Registration) request.getAttribute("userData");
String rule = (String) request.getAttribute("userRule");
int idRegistration = (int) request.getAttribute("idRegistration");%>
<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <div class=" panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">Edit Selected User</h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" action="updateRegistration" method="post">
                    <div class="form-group">
                        <label for="inputFirstName" class="col-sm-3 control-label">First Name</label>
                        <div class="col-sm-9">
                            <input type="text" name="firstName" class="form-control" id="inputFirstName"
                                   value="<%=registration.getFirstName()%>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputLastName" class="col-sm-3 control-label">Last Name</label>
                        <div class="col-sm-9">
                            <input type="text" name="lastName" class="form-control" id="inputLastName"
                                   value="<%=registration.getLastName()%>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-3 control-label">Email</label>
                        <div class="col-sm-9">
                            <input type="email" name="email" class="form-control" id="inputEmail3" value="<%=registration.getEmail()%>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-3 control-label">Role</label>
                        <div class="col-sm-9">
                            <select type="text" name="role" class="form-control" id="inputRole">
                                <option ><%=UserRule.ADMIN%></option>
                                <option ><%=UserRule.STUDENT%></option>
                                <option ><%=UserRule.TEACHER%></option>
                                <option ><%=UserRule.GUEST%></option>
                            </select>
                            <%--<input type="text" name="role" class="form-control" id="inputRole" value="<%=rule%>">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-9">
                            <form action="/updateRegistration" method="post">
                                <input type="hidden" value="<%=idRegistration%>" name="idRegistration">
                                <button type="submit" class="btn btn-success btn-block ">Save</button>
                            </form>
                                <a class="btn btn-danger btn-block " href="admin.jsp"> Return to admin page</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>