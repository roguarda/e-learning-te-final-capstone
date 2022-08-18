<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<c:url var="validationJs" value="/js/user-validation.js"/>
<script src="${validationJs}"></script>

<c:url var="formAction" value="/CreateCourse"/>
<form method="POST" action="${formAction}">
    <input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <div class="form-group">
                <label for="name"> Course Name: </label>
                <input type="text" id="name" name="name" placeHolder=" Name" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="teacherId"> Teacher ID: </label>
                <input type="number" id="teacherId" name="teacherId" placeHolder=" ID" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="description"> Course Description: </label>
                <input type="text" id="description" name="description" placeHolder="description" class="form-control"/>
            </div>
<%--            <div class="form-group">--%>
<%--                <label for="description">Course Description: </label>--%>
<%--                <input type="text" id="description" name="description" class="form-control"/>--%>
<%--            </div>--%>
            <div class="form-group">
                <label for="difficultyLevel">Course difficulty: </label>
                <select id="difficultyLevel" name="difficultyLevel" class="form-control">
                    <option value="" selected disabled>Please select a difficulty:</option>
                    <option value="low">Low</option>
                    <option value="mid">Mid</option>
                    <option value="high">High</option>
                </select>
            </div>
            <div class="form-group">
                <label for="cost"> Course cost: </label>
                <input type="text" id="cost" name="cost" placeHolder="cost" class="form-control"/>
            </div>
<%--            <div class="form-group">--%>
<%--                <label for="cost">Course cost: </label>--%>
<%--                <select id="cost" name="cost" class="form-control">--%>
<%--                    <option value="" selected disabled>Please select a cost:</option>--%>
<%--                    <option value="free">FREE!</option>--%>
<%--                </select>--%>
<%--            </div>--%>


            <button type="submit" class="btn btn-primary">Create Course</button>
        </div>
        <div class="col-sm-4"></div>
    </div>
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>

<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>--%>
<%--<c:import url="/WEB-INF/jsp/common/header.jsp"/>--%>
<%--<c:url var="validationJs" value="/js/user-validation.js" />--%>
<%--<script src="${validationJs}"></script>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>


<%--<c:set var="pageTitle" value="Registrations"/>--%>

<%--<h2>Create a Course</h2>--%>

<%--<c:url value="/CreateCourse" var="courseRegistration" />--%>
<%--<form:form action="${register}" method="POST" modelAttribute="registrationCourse">--%>

<%--    <div>--%>
<%--        &lt;%&ndash;@declare id="name"&ndash;%&gt;<label for="Name"> Name</label>--%>
<%--        <form:input  path="name" class="form-control"/>--%>
<%--        <form:errors path="name" cssClass="error"/>--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        &lt;%&ndash;@declare id="description"&ndash;%&gt;<label for="Description">Description</label>--%>
<%--        <form:input  path="description" class="form-control" />--%>
<%--        <form:errors path="description" cssClass="error"/>--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        &lt;%&ndash;@declare id="difficulty level"&ndash;%&gt;<label for="Difficulty Level">Difficulty Level</label>--%>

<%--                    <div class="form-group">--%>
<%--                        <select  id="difficultyLevel" name="difficultyLevel"  class="form-control">--%>
<%--                            <option>Low</option>--%>
<%--                            <option>Mid</option>--%>
<%--                            <option>High</option>--%>


<%--                        </select>--%>
<%--                    </div>--%>

<%--            </div>--%>
<%--            <div>--%>
<%--                &lt;%&ndash;@declare id="cost"&ndash;%&gt;<label for="Cost">Cost</label>--%>
<%--        <form:input  path="cost" class="form-control" />--%>
<%--        <form:errors path="cost" cssClass="error"/>--%>
<%--    </div>--%>

<%--    <div>--%>
<%--        <input type="submit" class="btn btn-primary" value="Submit"/>--%>
<%--    </div>--%>
<%--</form:form>--%>

<%--<%@include file="../common/footer.jsp" %>--%>

