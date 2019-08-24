<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="mt-4">Edit Profile</h1>
<div class="mx-auto border rounded">
    <div class="p-2 bg-light border-bottom">Profile Form Elements</div>
    <form:form cssClass="p-2" action="update-profile" modelAttribute="memberModel" method="post">
        <div class="form-group">
            <form:label path="firstName" cssClass="font-weight-bold">First Name:</form:label>
            <form:input cssClass="form-control" placeholder="Enter the first name" path="firstName"/>
            <form:errors path="firstName" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <form:label path="lastName" cssClass="font-weight-bold">Last Name:</form:label>
            <form:input cssClass="form-control" placeholder="Enter the last name" path="lastName"/>
            <form:errors path="lastName" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <form:label path="email" cssClass="font-weight-bold">Email:</form:label>
            <form:input type="email" cssClass="form-control" placeholder="Enter the email" path="email"
                        readonly="true"/>
            <form:errors path="email" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <form:label path="phone" cssClass="font-weight-bold">Phone:</form:label>
            <form:input cssClass="form-control" placeholder="Enter your phone number" path="phone"/>
            <form:errors path="phone" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <form:label path="description" cssClass="font-weight-bold">Description:</form:label>
            <form:textarea cssClass="form-control" path="description" rows="5"/>
            <form:errors path="description" cssClass="text-danger"/>
        </div>
        <div class="d-flex">
            <button type="submit" class="btn btn-outline-dark mr-3">Submit</button>
            <button id="resetProfileButton" type="reset" class="btn btn-outline-dark">Reset</button>
        </div>
        <h3 class="mt-3 text-primary">${notification}</h3>
    </form:form>
</div>

<script src="js/profile.js"></script>