<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url var="popup" value="/js/popup.js" />
<script src="${popup}"></script>


<div class="row">
    <div>
        <h1 align="center"> Teacher</h1>
    </div>
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">Course</h5>
            <a href="CreateCourse" class="btn btn-primary">Add course</a>
            <a href="TeacherCurrentCourses" class="btn btn-primary">See my current Courses</a>
            <a href="allCourses" class="btn btn-primary">See all courses</a>
        </div>
    </div>
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">Curricula</h5>

            <a href="Curricula" class="btn btn-primary">All curricula</a>
            <a href="CreateCurricula" class="btn btn-primary">Add curricula</a>
        </div>
    </div>
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">Homework</h5>
            <a href="Curricula" class="btn btn-primary">All curricula</a>


        </div>
    </div>
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">All courses</h5>

        </div>
    </div>


</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />
