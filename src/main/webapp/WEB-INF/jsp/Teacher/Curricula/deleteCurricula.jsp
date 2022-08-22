<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 19/8/2022
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:import url="/WEB-INF/jsp/common/header.jsp" />


<c:url var="deleteLink" value="/deleteCurricula/${curricula.id}" />
<form class="detail-container" action="${deleteLink}" method="post">
    <input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
    <div class="detail-row">
        You are about to delete <strong>${curricula.curriculaName}</strong> do you want to continue?
    </div>
    <div class="detail-row">
        <input type="submit" value="Delete">
        <c:url var="curriculaUrl" value="/deleteCurricula/${curricula.id}" />
        <a href="${curriculaUrl}">Cancel</a>
    </div>
</form>


<c:import url="../../common/footer.jsp"/>