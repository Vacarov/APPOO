<%@ page import="com.database.UI.LabelColor" %>
<%@ page import="com.database.data.quiz.quiz.Answer" %>
<%@ page import="com.database.data.quiz.quiz.Quiz" %>
<%@ page import="com.database.data.quiz.quiz.QuizRepository" %>
<%@ page import="com.database.data.quiz.quiz.Variant" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: wergin
  Date: 20-Apr-17
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%String title = "Result Test";%>
<%@include file="blocks/header.jsp" %>
<%@include file="blocks/checks/check-user-session.jsp" %>
<body>
<%
    HttpSession session1 = request.getSession();
    int idTest = Integer.parseInt(session1.getAttribute("idTest").toString());
    Map<Integer, String> q_checks = (Map<Integer, String>) request.getAttribute("q_checks");
    Map<Integer, Variant> wrongResponses = (Map<Integer, Variant>) request.getAttribute("wrongResponses");
    System.out.println(wrongResponses);
    List<Quiz> quizList = QuizRepository.getQuizesByIdTest(idTest);
%>
<div class="container-fluid bg-info">
    <%@include file="blocks/overview/test/form-result.jsp" %>
    <br><br>
    <%
        int nr_question = 1;
        for (Quiz quiz : quizList) {
    %>
    <form action="/giveAnswer" , method="post">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h3><span class="label label-warning" id="qid"><%=nr_question++%></span> <%=quiz.getQuestion()%>
                    </h3>
                </div>
                <div class="modal-body">
                    <div class="col-xs-5 col-xs-offset-7">
                        <div id="loadbar" style="display: none;">
                            <div class="blockG" id="rotateG_01"></div>
                            <div class="blockG" id="rotateG_02"></div>
                            <div class="blockG" id="rotateG_03"></div>
                            <div class="blockG" id="rotateG_04"></div>
                            <div class="blockG" id="rotateG_05"></div>
                            <div class="blockG" id="rotateG_06"></div>
                            <div class="blockG" id="rotateG_07"></div>
                            <div class="blockG" id="rotateG_08"></div>
                        </div>
                    </div>
                    <div class="quiz" id="quiz" data-toggle="buttons">
                        <%
                            Map<Variant, String> map = quiz.getVariants();
                            Map<Integer, Variant> rightResponses = (Map<Integer, Variant>) request.getAttribute("rightResponses");
                            LabelColor labelColor = new LabelColor();
                        %>
                        <label style="text-align: left !important;"
                               class="element-animation1 btn btn-lg
<%--%> btn-danger<%}else{%>--%>
<%=labelColor.setColor(rightResponses,quiz,Variant.A)%> <%if (wrongResponses.containsKey(quiz.getIdQuiz())){%><%=labelColor.setColorForWrongResponse(wrongResponses,quiz,Variant.A)%> <%}%>
<%--<%}%>--%>
btn-block"><span class="btn-label"><i
                                class="glyphicon glyphicon-chevron-right"></i></span> <input type="radio"
                                                                                             name="q_answer<%=quiz.getIdQuiz()%>"
                                                                                             value="<%=Variant.A%>">A. <%=map.get(Variant.A)%>
                        </label>
                        <label style="text-align: left !important;"
                               class="element-animation2 btn btn-lg  <%=labelColor.setColor(rightResponses,quiz,Variant.B)%>

<%if (wrongResponses.containsKey(quiz.getIdQuiz())){%><%=labelColor.setColorForWrongResponse(wrongResponses,quiz,Variant.B)%> <%}%>


                               %> btn-block"><span
                                class="btn-label"><i
                                class="glyphicon glyphicon-chevron-right"></i></span> <input type="radio"
                                                                                             name="q_answer<%=quiz.getIdQuiz()%>"
                                                                                             value="B">B. <%=map.get(Variant.B)%>
                        </label>
                        <label style="text-align: left !important;"
                               class="element-animation3 btn btn-lg <%=labelColor.setColor(rightResponses,quiz,Variant.C)%>


                                <%if (wrongResponses.containsKey(quiz.getIdQuiz())){%><%=labelColor.setColorForWrongResponse(wrongResponses,quiz,Variant.C)%> <%}%>

                                btn-block"><span
                                class="btn-label"><i
                                class="glyphicon glyphicon-chevron-right"></i></span> <input type="radio"
                                                                                             name="q_answer<%=quiz.getIdQuiz()%>"
                                                                                             value="C">C. <%=map.get(Variant.C)%>
                        </label>
                        <label style="text-align: left !important;"
                               class="element-animation4 btn btn-lg <%=labelColor.setColor(rightResponses,quiz,Variant.D)%>
                                                                <%if (wrongResponses.containsKey(quiz.getIdQuiz())){%><%=labelColor.setColorForWrongResponse(wrongResponses,quiz,Variant.D)%> <%}%>

                                btn-block"><span
                                class="btn-label"><i
                                class="glyphicon glyphicon-chevron-right"></i></span> <input type="radio"
                                                                                             name="q_answer<%=quiz.getIdQuiz()%>"
                                                                                             value="D">D. <%=map.get(Variant.D)%>
                        </label>
                    </div>
                </div>
                <div class="modal-footer text-muted">
                    <span id="answer"><%=q_checks.get(quiz.getIdQuiz())%></span>
                </div>
            </div>
        </div>
        <input type="hidden" value="<%=quiz.getIdQuiz()%>" name="idQuiz<%=quiz.getIdQuiz()%>">
        <%}%>
    </form>
    <br>
    <br>
    <br>
</div>
</body>
</html>