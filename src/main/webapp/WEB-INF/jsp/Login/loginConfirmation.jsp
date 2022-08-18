<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 15/8/2022
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/header.jsp"%>
<c:url var="formAction" value="/users/loginConfirmation" />

<h1>Confirmation</h1>
<p>You have successfully logged in!</p>

<%--add user homepage to this button--%>
<<<<<<< HEAD
<div>

    <button
            onclick="window.location.href = '/login';">
        Login
    </button>


</div>
=======


<c:choose>

    <c:when test="${app_user.is_student}">
<c:url var="studentUrl" value="/studentHomePage"></c:url>

        <a href="${studentUrl}" class="btn btn-primary">Go to main page</a>

    </c:when>

    <c:otherwise>
        <c:url var="teacherUrl" value="/teacherHomePage"></c:url>
        <a href="${teacherUrl}" class="btn btn-primary">Go to main page</a>

    </c:otherwise>

</c:choose>
>>>>>>> main


<%@include file="../common/footer.jsp"%>
