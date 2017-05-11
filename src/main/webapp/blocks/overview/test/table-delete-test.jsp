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