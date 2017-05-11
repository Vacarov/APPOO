<%@ page import="com.database.data.quiz.test.TestRepository" %>
<%@ page import="com.database.data.quiz.test.Test" %>
<!DOCTYPE html>
<html lang="en">
<%String title = "edit test";%>
<%@include file="blocks/header.jsp"%>
<%@include file="blocks/checks/check-user-session.jsp" %>
<body>
<% int idTest = Integer.parseInt(request.getAttribute("idTest").toString());
    TestRepository testRepository = new TestRepository();
    Test test = testRepository.findTestByIdTest(idTest);%>
<br><br><br><br>
<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <div class=" panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">Add Test</h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" action="/updateTest" method="post">
                    <div class="form-group">
                        <label for="inputName" class="col-sm-3 control-label">Subject : </label>
                        <div class="col-sm-9">
                            <input type="text" name="testName" class="form-control" id="inputName" value="<%=test.getName()%>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputName" class="col-sm-3 control-label">Time (in min) : </label>
                        <div class="col-sm-9">
                            <input type="text" name="testTime" class="form-control" id="inpuTime" value="<%=test.getTime()%>">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-9">
                            <form action="/updateTest" method="post">
                                <input type="hidden" name="idTest" value="<%=idTest%>">
                                <button type="submit" class="btn btn-success btn-block ">Edit Test</button>
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