<%@ page import="com.database.data.quiz.test.Test" %>
<%@ page import="com.database.data.quiz.test.TestRepository" %>
<%
    TestRepository testRepository = new TestRepository();
    Test test = testRepository.findTestByIdTest(idTest);
    Answer answer = new Answer();
%>
<div class="container">
    <div id="signupbox" style=" margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-title panel-primary">
            <div class="panel-heading">
                <div class="panel-title">Test Result</div>
            </div>
            <div class="panel-body">
                <form method="post" action=".">
                    <form class="form-horizontal" method="post">
                        <div id="div_id_testname" class="form-group required">
                            <label for="id_testname" class="control-label col-md-4  requiredField"><span><i
                                    class="glyphicon glyphicon glyphicon-education "></i></span> Test Name : <span
                                    class="asteriskField"></span> </label>
                            <div class="controls col-md-8 ">
                                <label id="id_testname"><%=test.getName()%>
                                </label>
                            </div>
                        </div>
                        <div id="div_id_total" class="form-group required">
                            <label for="id_total" class="control-label col-md-4  requiredField"><span><i
                                    class="glyphicon glyphicon glyphicon-tasks"></i></span> Total : <span
                                    class="asteriskField"></span> </label>
                            <div class="controls col-md-8 ">
                                <label id="id_total"><%=q_checks.size()%>
                                </label>
                            </div>
                        </div>
                        <div id="div_id_right_response" class="form-group required">
                            <label for="id_right_response" class="control-label col-md-4  requiredField"><span><i
                                    class="glyphicon glyphicon glyphicon-ok btn-success"></i></span> Correct : <span
                                    class="asteriskField"></span> </label>
                            <div class="controls col-md-8 ">
                                <label id="id_right_response"><%=answer.countNumberOfRightResponse(q_checks)%>
                                </label>
                            </div>
                        </div>
                        <div id="div_id_wrong_response" class="form-group required">
                            <label for="id_wrong_response" class="control-label col-md-4  requiredField"><span><i
                                    class="glyphicon glyphicon glyphicon-remove btn-danger"></i></span> Wrong : <span
                                    class="asteriskField"></span> </label>
                            <div class="controls col-md-8 ">
                                <label id="id_wrong_response"><%=answer.countNumberOfWrongResponse(q_checks)%>
                                </label>
                            </div>
                        </div>
                        <div id="div_id_no_answer" class="form-group required">
                            <label for="id_no_answer" class="control-label col-md-4  requiredField"><span><i
                                    class="glyphicon glyphicon glyphicon-minus btn-warning"></i></span> No answer : <span
                                    class="asteriskField"></span> </label>
                            <div class="controls col-md-8 ">
                                <label id="id_no_answer"><%=answer.countNumberOfNoAnswer(q_checks)%>
                                </label>
                            </div>
                        </div>
                    </form>
                </form>
            </div>
        </div>
    </div>
</div>
</div>