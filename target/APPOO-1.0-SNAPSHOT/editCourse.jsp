<%@ page import="com.database.data.Registration" %>
<%@ page import="com.database.data.UserRule" %>
<%@ page import="com.database.data.quiz.course.CourseRepository" %>
<!DOCTYPE html>
<html lang="en">
<%String title = "edit course";%>
<%@include file="blocks/header.jsp"%>
<%@include file="blocks/checks/check-user-session.jsp" %>
<body>
<br><br><br><br>
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