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


<c:choose>

    <c:when test="${app_user.role == student}">

        <button href="studentHomePage" class="btn btn-primary">Go to main page</button>

    </c:when>

    <c:otherwise>
        <button href="teacherHomePage" class="btn btn-primary">Go to main page</button>

    </c:otherwise>

</c:choose>


<%@include file="../common/footer.jsp"%>
