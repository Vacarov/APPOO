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
<%String title = "test";%>
<%@include file="blocks/header.jsp" %>
<%@include file="blocks/checks/check-user-session.jsp" %>
<body>
<%
    HttpSession session1 = request.getSession();
    int idTest = Integer.parseInt(session1.getAttribute("idTest").toString());
%>
<div class="container-fluid bg-info">
    <%
        List<Quiz> quizList = QuizRepository.getQuizesByIdTest(idTest);
        int nr_question = 1;
        for (Quiz quiz : quizList) {
    %>
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h3><span class="label label-warning" id="qid"><%=nr_question++%></span> <%=quiz.getQuestion()%>
                </h3>
            </div>
            <form action="/giveAnswer" , method="post">
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
                        <%Map<Variant, String> map = quiz.getVariants();%>
                        <label style="text-align: left !important;"
                               class="element-animation1 btn btn-lg btn-primary btn-block"><span class="btn-label"><i
                                class="glyphicon glyphicon-chevron-right"></i></span> <input style="" type="radio"
                                                                                             name="q_answer"
                                                                                             value="<%=Variant.A%>">A. <%=map.get(Variant.A)%>
                        </label>
                        <label style="text-align: left !important;"
                               class="element-animation2 btn btn-lg btn-primary btn-block"><span class="btn-label"><i
                                class="glyphicon glyphicon-chevron-right"></i></span> <input type="radio"
                                                                                             name="q_answer"
                                                                                             value="B">B. <%=map.get(Variant.B)%>
                        </label>
                        <label style="text-align: left !important;"
                               class="element-animation3 btn btn-lg btn-primary btn-block"><span class="btn-label"><i
                                class="glyphicon glyphicon-chevron-right"></i></span> <input type="radio"
                                                                                             name="q_answer" value="C">C. <%=map.get(Variant.C)%>
                        </label>
                        <label style="text-align: left !important;"
                               class="element-animation4 btn btn-lg btn-primary btn-block"><span class="btn-label"><i
                                class="glyphicon glyphicon-chevron-right"></i></span> <input type="radio"
                                                                                             name="q_answer" value="D">D. <%=map.get(Variant.D)%>
                        </label>
                        <%--<label class="element-animation4 btn btn-success btn-block">--%>
                            <%--&lt;%&ndash;<input type="hidden" value="<%=quiz.getIdQuiz()%>" name="idQuiz">&ndash;%&gt;--%>
                            <%--<button type="submit" class="element-animation4 btn btn-success btn-block">Response</button>--%>
                        <%--</label>--%>
                    </div>
                </div>
                <div class="modal-footer text-muted">
                    <span id="answer"><%=request.getParameter("resp")%></span>
                </div>
            </form>
        </div>
    </div>
    <%}%>
    <label style="" class="element-animation4 btn btn-success">
        <%--<input type="hidden" value="<%=quiz.getIdQuiz()%>" name="idQuiz">--%>
        <button type="submit" class="element-animation4 btn btn-success btn-block">Finish Test</button>
    </label>
    <br>
    <br>
    <br>
</div>
</body>
</html>