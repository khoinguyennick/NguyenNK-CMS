<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="mt-4">Add Content</h1>
<div class="mx-auto border rounded">
    <div class="p-2 bg-light border-bottom">Content Form Elements</div>
    <form:form cssClass="p-2" method="post" action="insert-content" modelAttribute="contentModel">
        <div class="form-group">
            <form:label path="title" cssClass="font-weight-bold">Title:</form:label>
            <form:input path="title" cssClass="form-control" placeholder="Enter the title"/>
            <form:errors path="title" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <form:label path="brief" class="font-weight-bold">Brief:</form:label>
            <form:textarea cssClass="form-control" path="brief"/>
            <form:errors path="brief" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <form:label path="content" class="font-weight-bold">Content:</form:label>
            <form:textarea class="form-control" path="content" rows="15"/>
            <form:errors path="content" cssClass="text-danger"/>
        </div>
        <div class="d-flex">
            <button type="submit" class="btn btn-outline-dark mr-3">Submit</button>
            <button id="resetFormButton" type="reset" class="btn btn-outline-dark">Reset</button>
        </div>
    </form:form>
</div>

<script src="js/form.js"></script>