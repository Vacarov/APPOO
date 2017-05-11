<%@ page import="com.database.data.RuleRepository" %>
<%@ page import="com.database.data.quiz.test.Test" %>
<%@ page import="com.database.data.quiz.test.TestRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="com.database.data.quiz.quiz.Quiz" %>
<%@ page import="com.database.data.quiz.quiz.QuizRepository" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.database.data.quiz.quiz.Variant" %>
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
                        <th>Question</th>
                        <th>A</th>
                        <th>B</th>
                        <th>C</th>
                        <th>D</th>
                        <th>Correct</th>
                        <th>Edit</th>
                        <th>Delete</th>
                        </thead>
                        <tbody>
                        <%
                            HttpSession session1 = request.getSession();
                            int idTest = Integer.parseInt(session1.getAttribute("idTest").toString());
                            List<Quiz> quizList = QuizRepository.getQuizesByIdTest(idTest);
                            for (Quiz quiz : quizList) {
                        %>
                        <tr>
                            <td><%=quiz.getQuestion()%>
                            </td>
                            <%Map<Variant,String> map = quiz.getVariants();%>
                            <td><%=map.get(Variant.A)%>
                            </td>
                            <td><%=map.get(Variant.B)%>
                            </td>
                            </td>
                            <td><%=map.get(Variant.C)%>
                            </td>
                            </td>
                            <td><%=map.get(Variant.D)%>
                            </td>
                            <td><%=quiz.getRightVariant().toString()%>
                            </td>
                            <%@include file="blocks/overview/quiz/table-edit-quiz.jsp" %>
                            <%@include file="blocks/overview/quiz/table-delete-quiz.jsp" %>
                        </tr>
                        <%}%>
                        <%@include file="blocks/overview/quiz/table-footer-add-quiz.jsp" %>
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