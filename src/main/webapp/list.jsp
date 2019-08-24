<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="mt-4">View Content</h1>
<table class="table table-bordered table-hover">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Title</th>
        <th scope="col">Brief</th>
        <th scope="col">Created Date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${contentList}" var="content" varStatus="count">
        <tr>
            <th scope="row">${count.index}</th>
            <td>${content.title}</td>
            <td>${content.brief}</td>
            <td>${content.createdDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>