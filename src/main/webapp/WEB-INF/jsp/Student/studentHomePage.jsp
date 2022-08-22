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
        <%-- <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>--%>
        <c:url value="/studentHomePage/profile" var="Profile" />
        <a href="/studentHomePage/profile" class="btn btn-primary">Go to my profile</a>
    </div>
</div>
<div class="card" style="width: 18rem;">
    <div class="card-body">
        <h5 class="card-title">My current courses</h5>
        <%-- <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>--%>
        <a href="StudentCurrentCourses" class="btn btn-primary">current courses</a>
    </div>
</div>
<div class="card" style="width: 18rem;">
    <div class="card-body">
        <h5 class="card-title">Finished Courses</h5>
        <%--<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>--%>
        <a href="finishedCourses" class="btn btn-primary">My finished courses</a>
    </div>
</div>
<div class="card" style="width: 18rem;">
    <div class="card-body">
        <h5 class="card-title">All courses</h5>
        <%--<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>--%>
        <a href="allCourses" class="btn btn-primary">See all courses</a>
    </div>
</div>
</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />