<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 24/8/2022
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:import url="/WEB-INF/jsp/common/header.jsp" />


<c:url var="enrollLink" value="/course/enroll/${course.id}" />
<form class="detail-container" action="${enrollLink}" method="post">
  <input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
  <div class="detail-row">
    You are about to enroll in  <strong>${course.name}</strong> do you want to continue?
  </div>
  <div class="detail-row">
    <input type="submit" value="Yes">
    <c:url var="courseUrl" value="/allCourses" />
    <a href="${courseUrl}">Cancel</a>
  </div>
</form>


<c:import url="/WEB-INF/jsp/common/footer.jsp"/>