<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<div class="row">
    <div>
        Student
    </div>
</div>
<div class="card" style="width: 18rem;">
    <div class="card-body">
        <h5 class="card-title">Profile</h5>
        <c:url var="profile" value="/profile/${currentUser.userId}"></c:url>
        <a href="${profile}" class="btn btn-primary">Go to my profile</a>
    </div>
</div>
<div class="card" style="width: 18rem;">
    <div class="card-body">
        <h5 class="card-title">My current courses</h5>
        <c:url var="currentCourses" value="/courses/student/${currentUser.userId}"></c:url>
        <a href="${currentCourses}" class="btn btn-primary">current courses</a>
    </div>
</div>

<div class="card" style="width: 18rem;">
    <div class="card-body">
        <h5 class="card-title">All courses</h5>
        <c:url var="allCourses" value="/allCourses"></c:url>
        <a href="${allCourses}" class="btn btn-primary">See all courses</a>
    </div>
</div>
</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />