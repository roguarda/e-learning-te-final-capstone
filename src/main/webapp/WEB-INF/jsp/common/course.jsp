<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<div id="course-detail">
       <%-- <c:url var="courseImageURL"
               value="/img/course-images/pexels-christina-morillo-1181290.jpg" />
        <img class="courseImage" src="${courseImageURL}">--%>
            <div class="course-name">
                <h3>${course.name}</h3>
        <div class="course-description">
            <h4>Description: ${course.description}</h4>
        </div>
        <div class="dificulty-level">
            <h4>Course difficulty level: ${course.difficultyLevel}</h4>
        </div>
        <div>
            <c:url var="curriculaURL" value="/curricula/details/${course.id}"></c:url>
            <a href="${curriculaURL}" class="btn btn-primary">Go to curricula</a>
        </div>
        <div>
            <c:choose>

                <c:when test="${currentUser.student}">
                    <a class="btn btn-primary">Enroll</a>
                </c:when>

                <c:otherwise>

                    <c:url var="editLink" value="/course/edit/${course.id}" />
                    <a href="${editLink}" class="btn btn-primary">edit</a> </button>

                    <c:url var="deleteLink" value="/course/delete/${course.id}" />
                    <a href="${deleteLink}" class="btn btn-primary" >delete</a></button>

                </c:otherwise>

            </c:choose>

        </div>

</div>

  <c:import url="/WEB-INF/jsp/common/footer.jsp" />
