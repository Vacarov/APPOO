<%@ page import="com.database.data.Registration" %>
<%@ page import="com.database.data.UserRule" %>
<%@ page import="com.database.data.quiz.course.CourseRepository" %>
<!DOCTYPE html>
<html lang="en">
<%String title = "add test";%>
<%@include file="blocks/header.jsp"%>
<%@include file="blocks/checks/check-user-session.jsp" %>
<body>
<br><br><br><br>
<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <div class=" panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">Add Test</h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" action="/addTest" method="post">
                    <div class="form-group">
                        <label for="inputName" class="col-sm-3 control-label">Subject : </label>
                        <div class="col-sm-9">
                            <input type="text" name="testName" class="form-control" id="inputName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputName" class="col-sm-3 control-label">Time (in min) : </label>
                        <div class="col-sm-9">
                            <input type="text" name="testTime" class="form-control" id="inpuTime">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-9">
                            <form action="/addTest" method="post">
                                <button type="submit" class="btn btn-success btn-block ">Create Test</button>
                            </form>
                            <a class="btn btn-danger btn-block " href="/testList.jsp"> Return to previous page</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>