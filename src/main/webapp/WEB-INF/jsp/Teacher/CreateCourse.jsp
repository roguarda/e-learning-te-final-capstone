<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<c:set var="pageTitle" value="Registrations"/>

<h2>Create a Course</h2>

<c:url value="/CreateCourse" var="courseRegistration" />
<form:form action="${register}" method="POST" modelAttribute="registrationCourse">

    <div>
        <%--@declare id="name"--%><label for="Name"> Name</label>
        <form:input  path="name" class="form-control"/>
        <form:errors path="name" cssClass="error"/>
    </div>
    <div>
        <%--@declare id="description"--%><label for="Description">Description</label>
        <form:input  path="description" class="form-control" />
        <form:errors path="description" cssClass="error"/>
    </div>
    <div>
        <%--@declare id="difficulty level"--%><label for="Difficulty Level">Difficulty Level</label>
        <form:input  path="difficultyLevel" class="form-control" />
        <form:errors path="difficultyLevel" cssClass="error"/>

    </div>
    <div>
        <%--@declare id="cost"--%><label for="Cost">Cost</label>
        <form:input  path="cost" class="form-control" />
        <form:errors path="cost" cssClass="error"/>
    </div>

    <div>
        <input type="submit" class="btn btn-primary" value="Submit"/>
    </div>
</form:form>

<%@include file="../common/footer.jsp" %>

