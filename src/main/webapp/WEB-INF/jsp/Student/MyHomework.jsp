<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<c:url var="validationJs" value="/js/user-validation.js"/>
<script src="${validationJs}"></script>

<c:url var="formAction" value="/MyHomework"/>
<form method="POST" action="${formAction}">
    <input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-3">
            <div class="form-group">
                <p>My Homework</p>
            </div>
            <div class="form-group">
                <label for="name" class="form-label mt-3"> Title: </label>
                <input type="text" id="name" name="name" placeHolder=" Name" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="introduction" class="form-label mt-3"> Homework's Introduction: </label>
                <input type="text" id="introduction" name="introduction" placeHolder="Introduction" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="description" class="form-label mt-3"> Homework's Description: </label>
                <input type="text" id="description" name="description" placeHolder="Description" class="form-control"/>
            </div>


            <button type="submit" class="btn btn-primary">Send my homework</button>
        </div>
        <div class="col-sm-3"></div>
    </div>
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>