<%@ page import="com.database.data.quiz.test.Test" %>
<%@ page import="com.database.data.quiz.test.TestRepository" %>
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
        <div class="col-md-9">
            <div class="profile-content">
                <div class="table-responsive">
                    <table id="mytable" class="table table-bordred table-striped">
                        <thead>
                        <th>Subject</th>
                        <th>Time (min.)</th>
                        <th>Author</th>
                        <th>Start</th>
                        <th>Edit</th>
                        <th>Delete</th>
                        </thead>
                        <tbody>
                            <%
                             HttpSession session1 = request.getSession();
                             int idCourse = Integer.parseInt(session1.getAttribute("idCourse").toString());
                             List<Test> testList = TestRepository.getTestsByIdCourse(idCourse);
                             for (Test test: testList) {
                        %>
                        <tr>
                            <td><%=test.getName()%>
                            </td>
                            <td><%=test.getTime()%>
                            </td>
                            <td><%=test.getAuthor()%>
                            </td>
                            <td>
                                <form action="/startTest" method="post">
                                    <input type="hidden" name="idTest" value="<%=test.getIdTest()%>">
                                    <button class="btn btn-primary btn-xs" data-title="startTest" data-toggle="modal"
                                            data-target="#startTest" type="submit"> Start test
                                    </button>
                                </form>
                            </td>
                            <td>
                                <form action="/editTest" method="post">
                                    <p data-placement="top" data-toggle="tooltip" title="Edit">
                                        <input type="hidden" value="<%=test.getIdTest()%>"
                                               name="idTest">
                                        <button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal"
                                                data-target="#edit" type="submit"><span
                                                class="glyphicon glyphicon-pencil"></span>
                                        </button>
                                    </p>
                                </form>
                            </td>
                            <td>
                                <form action="/deleteTest" method="post">
                                    <p data-placement="top" data-toggle="tooltip" title="Delete">
                                        <input type="hidden" value="<%=test.getIdTest()%>"
                                               name="idTest">
                                        <button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal"
                                                data-target="#delete" type="submit"><span
                                                class="glyphicon glyphicon-trash"></span>
                                        </button>
                                </form>
                                </p>
                            </td>
                        </tr>
                            <% }
                        %>
                        <tfoot>
                        <tr>
                            <th>
                                <a href="addTest.jsp" type="button" class="btn btn-success"><span
                                        class="glyphicon glyphicon-plus"></span> Add new test
                                </a>
                            </th>
                            <th></th>
                            <th></th>
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
<br>
<br>
</body>
</html>