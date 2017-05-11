<td>
    <form action="/editQuiz" method="post">
        <p data-placement="top" data-toggle="tooltip" title="Edit">
            <input type="hidden" value="<%=quiz.getIdQuiz()%>"
                   name="idQuiz">
            <button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal"
                    data-target="#edit" type="submit"><span
                    class="glyphicon glyphicon-pencil"></span>
            </button>
        </p>
    </form>
</td>