

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../common/header.jsp" %>

<c:url var="curriculaConfirmation" value="/CreateCurricula/CurriculaConfirmation" />





<div><h1>Confirmation</h1></div>
<div><p>You have successfully created Your Curricula! </p></div>

<%--este boton debería ir a la página del profesor... IDEALMENTE DEBERIA SER UN POP UP DE JS. --%>
<button  class="btn btn-primary" href="/teacherHomePage">Go to Teacher Main Page</button>

<%@include file="../common/footer.jsp"%>
