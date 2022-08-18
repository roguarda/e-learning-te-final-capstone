<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 18/8/2022
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="detail-row">
  <c:url var="addLink" value="/Curricula" />
  <a href="${addLink}" class="edit-link"> </a>
</div>

<table>
  <thead>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Instruction</th>
    <th>Homework</th>
      </thead>
  <tbody>
  <c:forEach var="curricula" items="${curricula}">
    <c:url var="curriculaLink" value="/curricula/details/${curricula.id}" />
    <tr>
      <td>${curricula.id}</td>
      <td>
        <a href="${curriculaLink}">${curricula.curriculaName}</a>
      </td>
      <td>${curricula.dailyInstruction}</td>
      <td>${curricula.dailyHomework}</td>
      <td>
        <c:url var="editLink" value="/curricula/edit/${curricula.id}" />
        <a href="${editLink}">edit</a>
        <c:url var="deleteLink" value="/curricula/delete/${curricula.id}" />
        <a href="${deleteLink}">delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<c:import url="../common/footer.jsp" />
