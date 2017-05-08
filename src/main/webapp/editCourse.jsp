<%@ page import="com.database.data.Registration" %>
<%@ page import="com.database.data.UserRule" %>
<%@ page import="com.database.data.quiz.course.CourseRepository" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Edit Course</title>

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
<% int idCourse = Integer.parseInt(request.getAttribute("idCourse").toString());
    CourseRepository courseRepository = new CourseRepository();%>
<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <div class=" panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">Edit Course</h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" action="updateCourse" method="post">
                    <div class="form-group">
                        <label for="inputCourseName" class="col-sm-3 control-label">Current course name: </label>
                        <div class="col-sm-9">
                            <input type="text" disabled="false" name="courseName" class="form-control" id="inputCourseName"
                                   value="<%=courseRepository.findNameById(idCourse)%>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputNewName" class="col-sm-3 control-label">Change name on : </label>
                        <div class="col-sm-9">
                            <input type="text" name="newCourseName" class="form-control" id="inputNewName">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-9">
                            <form action="/updateCourse" method="post">
                                <input type="hidden" value="<%=idCourse%>" name="idCourse">
                                <button type="submit" class="btn btn-success btn-block ">Save</button>
                            </form>
                            <a class="btn btn-danger btn-block " href="teacher.jsp"> Return to previous page</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>