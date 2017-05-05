<%@ page import="java.util.List" %>
<%@ page import="com.database.data.RegistrationRepository" %>
<%@ page import="com.database.data.Registration" %>
<%@ page import="com.database.data.RuleRepository" %>
<!DOCTYPE html>
<html lang="en">
<%String title = "Overview";%>
<%@include file="blocks/header.jsp"%>
<body>
<br><br><br><br>
<div class="container">
    <div class="row profile">
        <div class="col-md-3">
            <div class="profile-sidebar">
                <%@include file="blocks/sidebar-userpic.jsp"%>
                <%@include file="blocks/sidebar-profile.jsp"%>
                <%@include file="blocks/sidebar-buttons.jsp"%>
                <%@include file="blocks/sidebar-menu.jsp"%>
            </div>
        </div>
        <div class="col-md-9">
            <div class="profile-content">

            </div>
        </div>
    </div>
</div>
<br>
<br>
</body>
</html>
