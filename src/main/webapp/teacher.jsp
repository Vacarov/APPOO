<%@ page import="com.database.data.quiz.course.Course" %>
<%@ page import="com.database.data.quiz.course.CourseRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="com.database.data.RuleRepository" %>
<!DOCTYPE html>
<html lang="en">
<%String title = "Overview";%>
<%@include file="blocks/header.jsp"%>
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
        <div class="col-md-8">
            <div class="profile-content">
                <div class="table-responsive">
                    <table id="mytable" class="table table-bordred table-striped">
                        <thead>
                        <th>Course Name</th>
                        <th>Test</th>
                        <th>Edit</th>
                        <th>Delete</th>
                        </thead>
                        <tbody>
                            <%
                            List<Course> courseList = CourseRepository.getAllCourses();
                            for (Course course : courseList) {
                        %>
                        <tr>
                            <td><%=course.getName()%>
                            </td>
                            <td>
                                <form action="/testList" method="post">
                                    <p data-placement="top" data-toggle="tooltip" title="viewTests">
                                        <input type="hidden" name="idCourse" value="<%=course.getIdCourse()%>">
                                        <button class="btn btn-info btn-xs" data-title="viewTests" data-toggle="modal"
                                                data-target="#viewTests" type="submit"> View tests
                                        </button>
                                    </p>
                                </form>
                            </td>
                           <%@include file="blocks/overview/course/table-edit-course.jsp"%>
                           <%@include file="blocks/overview/course/table-delete-course.jsp"%>
                        </tr>
                            <% }
                        %>
                            <%@include file="blocks/overview/course/table-footer-add-course.jsp"%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>