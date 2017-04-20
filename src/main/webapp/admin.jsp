<%@ page import="java.util.List" %>
<%@ page import="com.database.data.RegistrationRepository" %>
<%@page import="com.database.data.Registration" %>
<%@ page import="com.database.data.RuleRepository" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/mycss/vertical-menu.css">
    <link rel="stylesheet" type="text/css" href="css/mycss/admin-list-panel.css">
    <link rel="stylesheet" type="text/css" href="css/mycss/admin-menu.css">
    <script type="text/javascript" src="jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="js/myjs/function.js"></script>
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Profile</title>

    <!-- Bootstrap -->
    <link href=" css/bootstrap.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <![endif]-->
</head>
<body>
<br><br><br><br>
<!-- Include all compiled plugins (below), or include individual files as needed -->


<!--
User Profile Sidebar by @keenthemes
A component of Metronic Theme - #1 Selling Bootstrap 3 Admin Theme in Themeforest: http://j.mp/metronictheme
Licensed under MIT
-->

<div class="container">
    <div class="row profile">
        <div class="col-md-3">
            <div class="profile-sidebar">
                <!-- SIDEBAR USERPIC -->
                <div class="profile-userpic">
                    <img src="http://keenthemes.com/preview/metronic/theme/assets/admin/pages/media/profile/profile_user.jpg"
                         class="img-responsive" alt="">
                </div>
                <!-- END SIDEBAR USERPIC -->
                <!-- SIDEBAR USER TITLE -->
                <div class="profile-usertitle">
                    <div class="profile-usertitle-name">
                        <%
                            RegistrationRepository registrationRepository = new RegistrationRepository();
                            String emailFromSession = session.getAttribute("emailLogin").toString();
                            int idRegistration = registrationRepository.findIdByEmail(emailFromSession);
                            String firstName = registrationRepository.findFirstNameById(idRegistration);
                            String lastName = registrationRepository.findLastNameById(idRegistration);
                        %>
                        <%=firstName + " " + lastName%>
                    </div>
                    <div class="profile-usertitle-job">
                        Administrator
                    </div>
                </div>
                <!-- END SIDEBAR USER TITLE -->
                <!-- SIDEBAR BUTTONS -->
                <div class="profile-userbuttons">
                    <button type="button" class="btn btn-success btn-sm">Follow</button>
                    <button type="button" class="btn btn-danger btn-sm">Message</button>
                </div>
                <!-- END SIDEBAR BUTTONS -->
                <!-- SIDEBAR MENU -->
                <div class="profile-usermenu">
                    <ul class="nav">
                        <li class="active">
                            <a href="#">
                                <i class="glyphicon glyphicon-home"></i>
                                Overview </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="glyphicon glyphicon-user"></i>
                                Account Settings </a>
                        </li>
                        <li>
                            <a href="#" target="_blank">
                                <i class="glyphicon glyphicon-ok"></i>
                                Tasks </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="glyphicon glyphicon-flag"></i>
                                Help </a>
                        </li>
                    </ul>
                </div>
                <!-- END MENU -->
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
                            RegistrationRepository registrationRepository1 =new RegistrationRepository();
                            RuleRepository ruleRepository = new RuleRepository();
                            for (Registration registration : registrations){
                                int idRule = registrationRepository1.findRuleIdById(registrationRepository1.findIdByEmail(registration.getEmail()));
                                String nameRule = ruleRepository.findNameById(idRule);
                        %>
                        <tr>
                            <td><input type="checkbox" class="checkthis"/></td>
                            <td><%=registration.getFirstName()%></td>
                            <td><%=registration.getLastName()%></td>
                            <td><%=registration.getEmail()%></td>
                            <td><%=nameRule%></td>
                            <td>
                                <p data-placement="top" data-toggle="tooltip" title="Edit">
                                    <button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal"
                                            data-target="#edit"><span class="glyphicon glyphicon-pencil"></span>
                                    </button>
                                </p>
                            </td>
                            <td>
                                <p data-placement="top" data-toggle="tooltip" title="Delete">
                                    <button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal"
                                            data-target="#delete"><span class="glyphicon glyphicon-trash" onclick="delete(1)"></span>
                                    </button>
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