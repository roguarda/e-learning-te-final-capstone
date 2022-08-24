<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>E-Learning</title>
    <c:url var="bootstrapCss" value="/css/superhero-bootstrap.min.css"/>
    <c:url var="siteCss" value="/css/site.css"/>

    <c:url var="jQueryJs" value="/js/jquery.min.js"/>
    <c:url var="jqValidateJs" value="/js/jquery.validate.min.js"/>
    <c:url var="jqvAddMethJs" value="/js/additional-methods.min.js"/>
    <c:url var="jqTimeagoJs" value="/js/jquery.timeago.js"/>
    <c:url var="popperJs" value="/js/popper.min.js"/>
    <c:url var="bootstrapJs" value="/js/bootstrap.min.js"/>

    <link rel="stylesheet" type="text/css" href="${bootstrapCss}">
    <link rel="stylesheet" type="text/css" href="${siteCss}">

    <script src="${jQueryJs}"></script>
    <script src="${jqValidateJs}"></script>
    <script src="${jqvAddMethJs}"></script>
    <script src="${jqTimeagoJs}"></script>
    <script src="${popperJs}"></script>
    <script src="${bootstrapJs}"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $("time.timeago").timeago();

            $("#logoutLink").click(function (event) {
                $("#logoutForm").submit();
            });

            var pathname = window.location.pathname;
            $("nav a[href='" + pathname + "']").parent().addClass("active");

        });
    </script>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <c:url var="elearningLogo" value="/img/e-learning-logo.png"/>
        <img src="${elearningLogo}" href="#" height="150px">
        <%--        <a class="navbar-brand" href="#">E-Learning</a>--%>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor02"
                aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"> </span>
        </button>
        <div class="collapse navbar-collapse" id="navbarColor02">
            <ul class="navbar-nav me-auto">
                <c:url var="homePageHref" value="/"/>
                <li class="nav-item"><a class="nav-link" href="${homePageHref}">Home</a></li>
                <%--                hasta aca todo bien--%>
                    <c:url var="studentUrl" value="/studentHomePage/profile"/>
                    <li class="nav-item"><a class="nav-link" href="${studentUrl}">My profile</a></li>

<%--                    <c:if test="${not empty currentUser}">--%>

<%--                    <c:url var="newMessageHref"--%>
<%--                           value="/users/${currentUser}/messages/new"/>--%>
<%--                <li class="nav-item"><a class="nav-link" href="${newMessageHref}">New Message</a></li>--%>
<%--                    <c:url var="sentMessagesHref"--%>
<%--                           value="/users/${currentUser}/messages"/>--%>
<%--                <li class="nav-item"><a class="nav-link" href="${sentMessagesHref}">Sent Messages</a></li>--%>
<%--                    <c:url var="changePasswordHref"--%>
<%--                           value="/users/${currentUser}/changePassword"/>--%>
<%--                <li class="nav-item"><a class="nav-link" href="${changePasswordHref}">Change Password</a></li>--%>
<%--                </c:if>--%>

                <ul class="navbar-nav ml-auto">
                    <c:choose>
                        <c:when test="${empty currentUser}">
                            <c:url var="newUserHref" value="/users/new"/>
                            <li class="nav-item"><a class="nav-link" href="${newUserHref}">Sign Up</a></li>
                            <c:url var="loginHref" value="/login"/>
                            <li class="nav-item"><a class="nav-link" href="${loginHref}">Log In</a></li>
                        </c:when>
                        <c:otherwise>
                            <c:url var="logoutAction" value="/logout"/>
                            <form id="logoutForm" action="${logoutAction}" method="POST">
                                <input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
                            </form>
                            <li class="nav-item"><a id="logoutLink" href="#">Log Out</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
        </div>
    </div>

</nav>


<c:if test="${not empty currentUser}">
<p id="currentUser">Current User: ${currentUser}</p>
</c:if>
<div class="container">
</div>