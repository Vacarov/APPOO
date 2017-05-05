<%@ page import="com.database.data.Registration" %>
<%@ page import="com.database.data.UserRule" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Edit User</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<br><br><br><br>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
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