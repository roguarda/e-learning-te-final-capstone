<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 15/8/2022
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/header.jsp" %>

<%--<c:url var="formAction" value="/newUserConfirmation" />--%>

<div><h1>Welcome ${sessionScope.currentUser} </h1></div>
<div><p>You have successfully registered!</p></div>

<div>
<<<<<<< HEAD
    <c:url var="loginURL" value="/login"></c:url>
=======
    <button
            onclick="window.location.href = '/login';">
        Login
    </button>
>>>>>>> main

    <a href="${loginURL}" class="btn btn-primary">Login</a>

</div>

<%@include file="../common/footer.jsp" %>
