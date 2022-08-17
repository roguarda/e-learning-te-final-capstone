<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="detail-row">
<c:url var="addLink" value="/allCourses" />
<a href="${addLink}" class="edit-link"> </a>
</div>

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Difficulty Level</th>
        <th>Cost</th>

        <th></th>
    </tr>

    </thead>
    <tbody>
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
                <c:url var="editLink" value="/course/edit/${course.id}" />
                <a href="${editLink}">edit</a>
                <c:url var="deleteLink" value="/course/delete/${course.id}" />
                <a href="${deleteLink}">delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<c:import url="../common/footer.jsp" />
