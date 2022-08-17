<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<c:set var="pageTitle" value="Registrations"/>

<h2>Create Curricula</h2>

<c:url value="/CreateCurricula" var="createCurricula"/>
<form:form action="${createCurricula}" method="POST" modelAttribute="curricula">

    <div>
            <%--@declare id="introduction"--%><label for="curriculaName"> Name:</label>
        <form:input path="curriculaName" class="form-control"/>
        <form:errors path="curriculaName" cssClass="error"/>
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

