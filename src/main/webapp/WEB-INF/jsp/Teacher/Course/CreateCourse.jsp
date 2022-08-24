<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<c:url var="validationJs" value="/js/user-validation.js"/>
<script src="${validationJs}"></script>

<c:url var="formAction" value="/CreateCourse"/>
<form method="POST" action="${formAction}">
    <input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <div class="form-group">
                <p> Teacher ID: ${currentUser.userId} </p>
            </div>
            <div class="form-group">
                <label for="name"> Course Name: </label>
                <input type="text" id="name" name="name" placeHolder=" Name" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="description"> Course Description: </label>
                <input type="text" id="description" name="description" placeHolder="description" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="difficultyLevel">Course difficulty: </label>
                <select id="difficultyLevel" name="difficultyLevel" class="form-control">
                    <option value="" selected disabled>Please select a difficulty:</option>
                    <option value="low">Low</option>
                    <option value="mid">Mid</option>
                    <option value="high">High</option>
                </select>
            </div>
            <div class="form-group">
                <label for="curriculaId">Choose curricula for this course: </label>
                <select id="curriculaId" name="curriculaId" class="form-control">
                    <option value="" selected disabled>Please select a curricula:</option>

                <c:forEach var="curriculaSelect" items="${curricula}">
                    <option value="${curriculaSelect.id}">${curriculaSelect.id} - ${curriculaSelect.curriculaName}</option>
                </c:forEach>

                </select>
            </div>

            <div class="form-group">
                <label for="cost">Course cost: </label>
                <select id="cost" name="cost" class="form-control">
                    <option value="" selected disabled>Please select a cost:</option>
                    <option value="free">FREE!</option>
                </select>
            </div>


            <button type="submit" class="btn btn-primary">Create Course</button>
        </div>
        <div class="col-sm-4"></div>
    </div>
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>



