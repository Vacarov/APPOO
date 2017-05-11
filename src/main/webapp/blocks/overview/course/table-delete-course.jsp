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