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
                <h3 class="panel-title">Add Quiz</h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" action="/addQuiz" method="post">
                    <div class="form-group">
                        <label for="inputQuestion" class="col-sm-3 control-label">Question : </label>
                        <div class="col-sm-9">
                            <input type="text" name="question" class="form-control" id="inputQuestion">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputVariantA" class="col-sm-3 control-label">A : </label>
                        <div class="col-sm-9">
                            <input type="text" name="variantA" class="form-control" id="inputVariantA">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputVariantB" class="col-sm-3 control-label">B : </label>
                        <div class="col-sm-9">
                            <input type="text" name="variantB" class="form-control" id="inputVariantB">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputVariantC" class="col-sm-3 control-label">C : </label>
                        <div class="col-sm-9">
                            <input type="text" name="variantC" class="form-control" id="inputVariantC">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputVariantD" class="col-sm-3 control-label">D : </label>
                        <div class="col-sm-9">
                            <input type="text" name="variantD" class="form-control" id="inputVariantD">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputRightVariant" class="col-sm-3 control-label">A : </label>
                        <div class="col-sm-9">
                            <select type="text" name="rightVariant" class="form-control" id="inputRightVariant">
                                <option>A</option>
                                <option>B</option>
                                <option>C</option>
                                <option>D</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-9">
                            <form action="/addQuiz" method="post">
                                <button type="submit" class="btn btn-success btn-block ">Add new Quiz</button>
                            </form>
                            <a class="btn btn-danger btn-block " href="/viewQuizzes.jsp"> Return to previous page</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>