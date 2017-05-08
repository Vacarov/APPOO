<%@ page import="com.database.data.Registration" %>
<%@ page import="com.database.data.UserRule" %>
<%@ page import="com.database.data.quiz.course.CourseRepository" %>
<!DOCTYPE html>
<html lang="en">
<%String title = "add course";%>
<%@include file="blocks/header.jsp"%>
<body>
<br><br><br><br>
<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <div class=" panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">Add Course</h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" action="addCourse" method="post">
                    <div class="form-group">
                        <label for="inputName" class="col-sm-3 control-label">Course name : </label>
                        <div class="col-sm-9">
                            <input type="text" name="courseName" class="form-control" id="inputName">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-9">
                            <form action="/addCourse" method="post">
                                <button type="submit" class="btn btn-success btn-block ">Add New Course</button>
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