<td>
    <form action="/deleteQuiz" method="post">
        <p data-placement="top" data-toggle="tooltip" title="Delete">
            <input type="hidden" value="<%=quiz.getIdQuiz()%>"
                   name="idQuiz">
            <button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal"
                    data-target="#delete" type="submit"><span
                    class="glyphicon glyphicon-trash"></span>
            </button>
        </p>
    </form>
</td>