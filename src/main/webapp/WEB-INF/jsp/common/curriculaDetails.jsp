<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<div class="detail-row">
  <c:url var="curriculaDetails" value="/curricula/details/${curriculaId}" />
  <a href="${curriculaDetails}" class="edit-link"> </a>
</div>

<figure class="text-center">
  <blockquote class="blockquote">
<div class="curricula-details">
  <h1>Curricula name: ${curricula.curriculaName} </h1>

    <div class="dailyInstruction">
      <h4>Daily Instructions: </h4>
      <td>
        ${curricula.dailyInstruction}
          </td>
    </div>
    <div class="daily-homework">
      <h4>Daily homework: </h4>
        <td>
        ${curricula.dailyHomework}
          </td>
    </div>
    <div>
      <c:choose>

        <c:when test="${currentUser.student}">
          <c:url var="studentUrl" value="/studentHomePage"></c:url>

          <a href="${studentUrl}" class="btn btn-primary">Go to main page</a>

        </c:when>

        <c:otherwise>
          <c:url var="teacherUrl" value="/teacherHomePage"></c:url>
          <a href="${teacherUrl}" class="btn btn-primary">Go to main page</a>

        </c:otherwise>

      </c:choose>

  </div>
    </blockquote>
    </figure>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />