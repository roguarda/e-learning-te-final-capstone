<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<c:url var="popup" value="/js/popup.js"/>
<script src="${popup}"></script>


<div class="row">
    <div>
        <h1> Teacher</h1>
    </div>
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">Course</h5>

            <div class="divbutton">
                <a href="CreateCourse" class="btn btn-primary">Add course</a>
            </div>
            <div class="divbutton">
                <c:url var="myCourses" value="/courses/teacher/${currentUser.userId}"></c:url>
                <a href="${myCourses}" class="btn btn-primary">My courses</a>
            </div>
            <div class="divbutton">
                <a href="allCourses" class="btn btn-primary">See all courses</a>
            </div>

        </div>
    </div>
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">Curricula</h5>

            <div class="divbutton">
                <a href="Curricula" class="btn btn-primary">All curricula</a>
            </div>
            <div class="divbutton">
                <a href="CreateCurricula" class="btn btn-primary">Add curricula</a>
            </div>

        </div>
    </div>
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">Homework</h5>
            <div class="divbutton">
                <a href="/viewHomework" class="btn btn-primary">Homework Grading</a>
            </div>
        </div>
    </div>
<%--    <div class="card" style="width: 18rem;">--%>
<%--        <div class="card-body">--%>
<%--            <h5 class="card-title">All courses</h5>--%>

<%--        </div>--%>
<%--    </div>--%>


</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
