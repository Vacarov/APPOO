<%@ page import="com.database.data.RuleRepository" %>
<%@ page import="com.database.data.quiz.test.Test" %>
<%@ page import="com.database.data.quiz.test.TestRepository" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<%String title = "list of test";%>
<%@include file="blocks/header.jsp" %>
<%@include file="blocks/checks/check-user-session.jsp" %>
<body>
<br><br><br><br>
<div class="container">
    <div class="row profile">
        <div class="col-md-3">
            <div class="profile-sidebar">
                <%@include file="blocks/sidebar-userpic.jsp" %>
                <%@include file="blocks/sidebar-profile.jsp" %>
                <%@include file="blocks/sidebar-buttons.jsp" %>
                <%@include file="blocks/sidebar-menu.jsp" %>
            </div>
        </div>
        <div class="col-md-9">
            <div class="profile-content">
                <div class="table-responsive">
                    <table id="mytable" class="table table-bordred table-striped">
                        <thead>
                        <th>Subject</th>
                        <th>Time (min.)</th>
                        <th>Author</th>
                        <%
                            RuleRepository ruleRepository = new RuleRepository();
                            if (ruleRepository.isTeacher(idRegistration)) {
                        %>
                        <th>View Quizzes</th>
                        <th>Edit</th>
                        <th>Delete</th>
                        <%}else{%>
                        <th>Start</th>
                        <%}%>
                        </thead>
                        <tbody>
                        <%
                            HttpSession session1 = request.getSession();
                            int idCourse = Integer.parseInt(session1.getAttribute("idCourse").toString());
                            List<Test> testList = TestRepository.getTestsByIdCourse(idCourse);
                            for (Test test : testList) {
                        %>
                        <tr>
                            <td><%=test.getName()%>
                            </td>
                            <td><%=test.getTime()%>
                            </td>
                            <td><%=test.getAuthor()%>
                            </td>
                            <%if (ruleRepository.isTeacher(idRegistration)) {%>
                            <td>
                                <form action="/viewQuizzes" method="post">
                                    <input type="hidden" name="idTest" value="<%=test.getIdTest()%>">
                                    <button class="btn btn-primary btn-xs" data-title="viewQuizzes" data-toggle="modal"
                                            data-target="#viewQuizzes" type="submit"> View Quizzes
                                    </button>
                                </form>
                            </td>
                            <%@include file="blocks/overview/test/table-edit-test.jsp" %>
                            <%@include file="blocks/overview/test/table-delete-test.jsp" %>
                            <%}else{%>
                            <td>
                                <form action="/startTest" method="post">
                                    <input type="hidden" name="idTest" value="<%=test.getIdTest()%>">
                                    <button class="btn btn-primary btn-xs" data-title="startTest" data-toggle="modal"
                                            data-target="#startTest" type="submit"> Start test
                                    </button>
                                </form>
                            </td>
                            <%}%>
                        </tr>
                        <%}%>
                        <%if (ruleRepository.isTeacher(idRegistration)) {%>
                        <%@include file="blocks/overview/test/table-footer-add-test.jsp" %>
                        <%}%>
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