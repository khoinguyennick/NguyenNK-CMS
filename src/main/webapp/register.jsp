<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: desert
  Date: 8/20/19
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
</head>
<body class="bg-light">

<div class="w-100">
    <div class="pt-5">
        <div class="w-25 mx-auto border rounded">
            <div class="p-2 bg-light border-bottom">Register</div>
            <form:form method="post" cssClass="p-2" action="${pageContext.request.contextPath}/create-member" modelAttribute="registerModel">
                <div class="form-group">
                    <form:input path="username" cssClass="form-control" placeholder="Username"/>
                    <form:errors path="username" cssClass="text-danger"/>
                </div>
                <div class="form-group">
                    <form:input path="email" type="email" cssClass="form-control" placeholder="Email"/>
                    <form:errors path="email" cssClass="text-danger"/>
                </div>
                <div class="form-group">
                    <form:password path="password" cssClass="form-control" placeholder="Password"/>
                    <form:errors path="password" cssClass="text-danger"/>
                </div>
                <div class="form-group">
                    <form:password path="rePassword" class="form-control" placeholder="Re-Password"/>
                    <form:errors path="rePassword" cssClass="text-danger"/>
                </div>
                <button type="submit" class="btn btn-success d-block mx-auto my-3 w-100">Register</button>
                <a class="text-decoration-none" href="${pageContext.request.contextPath}/login">Click here to login</a>
            </form:form>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/c4c22c9a2c.js"></script>
</body>
</html>
