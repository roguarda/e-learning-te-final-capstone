<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="detail-row">
    <c:url var="mycoursesLink" value="/courses/teacher/{teacherId}" />
    <a href="${mycoursesLink}" class="edit-link"> </a>
</div>

<h1>Courses</h1>

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
        <c:url var="courseLink" value="/courses/details/${course.id}" />
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

<c:import url="../../common/footer.jsp" />
