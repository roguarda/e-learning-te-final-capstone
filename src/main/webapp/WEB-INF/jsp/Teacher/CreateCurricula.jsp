<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<c:set var="pageTitle" value="Registrations"/>

<h2>Create a Curricula</h2>

<c:url value="/CreateCurricula" var="curricula Registration"/>
<form:form action="${register}" method="POST" modelAttribute="registrationCurricula">

    <div>
            <%--@declare id="introduction"--%><label for="Introduction"> Name:</label>
        <form:input path="introduction" class="form-control"/>
        <form:errors path="introduction" cssClass="error"/>
    </div>

    <div>
            <%--@declare id="daily instruction"--%><label for="Daily Instruction">Daily Instruction</label>
        <form:input path="dailyInstruction" class="form-control"/>
        <form:errors path="dailyInstruction" cssClass="error"/>
    </div>

    <div>
            <%--@declare id="daily homework"--%><label for="Daily Homework">Daily Homework</label>
        <form:input path="dailyHomework" class="form-control"/>
        <form:errors path="dailyHomework" cssClass="error"/>
    </div>

    <div>
        <input type="submit" class="btn btn-primary" value="Submit"/>
    </div>
</form:form>

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>

