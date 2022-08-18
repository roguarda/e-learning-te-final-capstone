<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url var="validationJs" value="/js/user-validation.js" />
<script src="${validationJs}"></script>

<c:url var="formAction" value="/CreateCurricula" />
<form method="POST" action="${formAction}">
    <input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <div class="form-group">
                <label for="curriculaName"> Name: </label>
                <input type="text" id="curriculaName" name="curriculaName" placeHolder=" Name" class="form-control" />
            </div>
            <div class="form-group">
                <label for="dailyInstruction">Daily Instruction: </label>
                <input type="text" id="dailyInstruction" name="dailyInstruction"  class="form-control" />
            </div>
            <div class="form-group">
                <label for="dailyHomework">Daily Homework: </label>
                <input type="text" id="dailyHomework" name="dailyHomework"  class="form-control" />
            </div>



            <button type="submit" class="btn btn-primary">Create Curricula</button>
        </div>
        <div class="col-sm-4"></div>
    </div>
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />

<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<c:import url="/WEB-INF/jsp/common/header.jsp"/>--%>

<%--&lt;%&ndash;<c:set var="createCurricula" value="/CreateCurricula"/>&ndash;%&gt;--%>

<%--<h2>Create Curricula</h2>--%>

<%--<c:url var="formAction" value="/CreateCurricula"/>--%>
<%--<form:form action="${formAction}" method="POST" modelAttribute="curricula">--%>

<%--    <div>--%>
<%--        <label class="col-form-label mt-4" for="curriculaName"> Name:</label>--%>
<%--        <form:input path="curriculaName" name="curriculaName" class="form-control"/>--%>
<%--        <form:errors path="curriculaName" cssClass="error"/>--%>
<%--    </div>--%>

<%--    <div>--%>
<%--        <label class="col-form-label mt-4" for="dailyInstruction">Daily Instruction</label>--%>
<%--        <form:input path="dailyInstruction" name="dailyInstruction" class="form-control"/>--%>
<%--        <form:errors path="dailyInstruction" cssClass="error"/>--%>
<%--    </div>--%>

<%--    <div>--%>
<%--        <label class="col-form-label mt-4" for="dailyHomework">Daily Homework</label>--%>
<%--        <form:input path="dailyHomework" name="dailyHomework" class="form-control"/>--%>
<%--        <form:errors path="dailyHomework" cssClass="error"/>--%>
<%--    </div>--%>

<%--    <div>--%>
<%--        <input type="submit" class="btn btn-primary" value="Submit"/>--%>
<%--    </div>--%>
<%--</form:form>--%>

<%--<c:import url="/WEB-INF/jsp/common/footer.jsp"/>--%>

