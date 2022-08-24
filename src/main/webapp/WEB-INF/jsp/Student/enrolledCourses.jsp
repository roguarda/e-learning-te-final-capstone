<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<h1>Your Enrolled Courses</h1>

<img class="courseImage" src="${courseImageURL}">

<div class="course-description">
    <h3>${course.description}</h3>
</div>
<div class="dificulty-level">
    <h3>${course.difficultyLevel}</h3>
</div>
<div>
    <c:url var="curriculaURL" value="/curricula"></c:url>
    <a href="${curriculaUrl}" class="btn btn-primary">Go to curricula</a>
</div>
<div>

</div>
