
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../common/header.jsp" %>

<c:url var="formAction" value="/courseConfirmation" />

<div><h1>Confirmation</h1></div>
<div><p>You have successfully registered Your Course!</p></div>

<div>
    <button
            onclick="window.location.href = '/users/login';">
        Login
    </button>


</div>

<%@include file="../common/footer.jsp" %>
