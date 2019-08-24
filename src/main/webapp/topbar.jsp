<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<nav class="navbar navbar-light bg-light border-bottom" style="z-index: 5">
    <a class="navbar-brand text-decoration-none text-dark"
       href="${pageContext.request.contextPath}/home">CMS</a>
    <div class="dropdown">
        <button class="btn dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-user"></i>
        </button>
        <div class="dropdown-menu mr-0" aria-labelledby="dropdownMenuButton" style="left: auto; right: 0">
            <button class="btn btn-link dropdown-item text-left p-0 pl-3" id="profile-link">
                <i class="fas fa-user"></i> User Profile
            </button>
            <div class="dropdown-divider"></div>
            <form:form cssClass="dropdown-item mb-0 p-0" action="logout" method="post">
                <button type="submit" class="btn w-100 bg-white text-left">
                    <i class="fas fa-sign-out-alt"></i> Logout
                </button>
            </form:form>
        </div>
    </div>
</nav>