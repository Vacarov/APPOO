<%@ page import="com.database.data.quiz.course.Course" %>
<%@ page import="com.database.data.quiz.course.CourseRepository" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<%String title = "Overview";%>
<%@include file="blocks/header.jsp" %>
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
        <div class="col-md-7">
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
                            <td>
                                <form action="/editCourse" method="post">
                                    <p data-placement="top" data-toggle="tooltip" title="Edit">
                                        <input type="hidden" value="<%=course.getIdCourse()%>"
                                               name="idCourse">
                                        <button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal"
                                                data-target="#edit" type="submit"><span
                                                class="glyphicon glyphicon-pencil"></span>
                                        </button>
                                    </p>
                                </form>
                            </td>
                            <td>
                                <form action="/deleteCourse" method="post">
                                    <p data-placement="top" data-toggle="tooltip" title="Delete">
                                        <input type="hidden" value="<%=course.getIdCourse()%>"
                                               name="idCourse">
                                        <button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal"
                                                data-target="#delete" type="submit"><span
                                                class="glyphicon glyphicon-trash"></span>
                                        </button>
                                    </p>
                                </form>

                            </td>
                        </tr>
                            <% }
                        %>
                        <tfoot>
                        <tr>
                            <th>
                                <a href="addCourse.jsp" type="button" class="btn btn-success"><span
                                        class="glyphicon glyphicon-plus"></span> Add new course
                                </a>
                            </th>
                            <th></th>
                            <th></th>
                            <th></th>
                        </tr>
                        </tfoot>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>