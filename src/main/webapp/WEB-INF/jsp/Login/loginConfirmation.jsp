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
<button><a >Go to Main Page</a></button>

<%@include file="../common/footer.jsp"%>
