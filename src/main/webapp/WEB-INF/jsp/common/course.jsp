<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<form method="POST" action="${formAction}">
    <input type="hidden" name="TOKEN" value="${TOKEN}"/>
    <figure class="text-center">
        <blockquote class="blockquote">
<div id="course-detail">
       <%-- <c:url var="courseImageURL"
               value="/img/course-images/pexels-christina-morillo-1181290.jpg" />
        <img class="courseImage" src="${courseImageURL}">--%>
            <div class="course-name">
                <h1>${course.name}</h1>
        <div class="course-description">
            <h4>Description: </h4>
            <td>
            ${course.description}
            </td>
        </div>
        <div class="dificulty-level">
            <h4>Course difficulty level: </h4>
            <td>
            ${course.difficultyLevel}
            </td>
        </div>
        <div>
            <c:url var="curriculaURL" value="/curricula/details/${course.id}"></c:url>
            <a href="${curriculaURL}" class="btn btn-primary">Go to curricula</a>
        </div>
        <div>
            <c:choose>

                <c:when test="${currentUser.student}">
                    <c:url var="enrollLink" value="/course/enroll/${course.id}" />
                    <a class="btn btn-primary" href="${enrollLink}" >Enroll</a>
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
        </blockquote>
    </figure>


  <c:import url="/WEB-INF/jsp/common/footer.jsp" />
