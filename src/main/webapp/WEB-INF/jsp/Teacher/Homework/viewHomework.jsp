<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="detail-row">
    <c:url var="addLink" value="/viewHomework" />
    <a href="${addLink}" class="edit-link"> </a>
</div>

<h1>Homeworks</h1>

<table class="table table-hover">
    <thead class="table-dark">
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Introduction</th>
        <th></th>
    </tr>

    </thead>
    <tbody class="table-active">
    <c:forEach var="homework" items="${homeworks}">
        <c:url var="homeworkLink" value="/homework/details/${homework.id}" />
        <tr>
            <td>${homework.id}</td>
            <td>
                <a href="${homeworkLink}">${homework.name}</a>
            </td>
            <td>${homework.introduction}</td>
            <td>${homework.description}</td>
            <td>
                <button type="button" class="btn btn-outline-info">
                    <c:url var="editLink" value="/homework/edit/${homework.id}" />
                    <a href="${editLink}">edit</a> </button>

            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>

<c:import url="../../common/footer.jsp" />

