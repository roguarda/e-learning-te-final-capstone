<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<div class="detail-row">
    <c:url var="enrolledLink" value="/courses/student/{studentId}" />
    <a href="${enrolledLink}" class="edit-link"> </a>
</div>
<h1>Your Enrolled Courses</h1>
<table class="table table-hover">
    <thead class="table-dark">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Difficulty Level</th>
        <th>Cost</th>

        <th></th>
    </tr>

    </thead>
    <tbody class="table-active">
    <c:forEach var="course" items="${courses}">
        <c:url var="courseLink" value="/course/details/${course.id}" />
        <tr>
            <td>${course.id}</td>
            <td>
                <a href="${courseLink}">${course.name}</a>
            </td>
            <td>${course.description}</td>
            <td>${course.difficultyLevel}</td>
            <td>${course.cost}</td>
            <td>
                <button type="button" class="btn btn-outline-info">
                    <c:url var="editLink" value="/course/edit/${course.id}" />
                    <a href="${editLink}">edit</a> </button>

            </td>
            <td>
                <button type="button" class="btn btn-outline-danger">
                    <c:url var="deleteLink" value="/course/delete/${course.id}" />
                    <a href="${deleteLink}">delete</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>






<%--<img class="courseImage" src="${courseImageURL}">--%>

<%--<div class="course-description">--%>
<%--    <h3>${course.description}</h3>--%>
<%--</div>--%>
<%--<div class="dificulty-level">--%>
<%--    <h3>${course.difficultyLevel}</h3>--%>
<%--</div>--%>
<%--<div>--%>
<%--    <c:url var="curriculaURL" value="/curricula"></c:url>--%>
<%--    <a href="${curriculaUrl}" class="btn btn-primary">Go to curricula</a>--%>
<%--</div>--%>
<%--<div>--%>

<%--</div>--%>
