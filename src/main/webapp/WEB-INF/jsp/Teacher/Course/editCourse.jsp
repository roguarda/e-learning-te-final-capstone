<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 22/8/2022
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<c:url var="validationJs" value="/js/user-validation.js"/>
<script src="${validationJs}"></script>

<c:url var="formAction" value="/course/edit/${course.id}"/>
<form method="POST" action="${formAction}">
    <input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">

            <div class="form-group">
                <p>Course id: ${course.id}</p>
            </div>
            <div class="form-group">
                <label for="updateCriteria"> Please select the field you want to edit: </label>
                <select id="updateCriteria" name="updateCriteria" class="form-control">
                    <option value="" selected disabled>Please select an option</option>
                    <option value="name">Course Name</option>
                    <option value="description">Course Description</option>
                    <option value="difficulty">Course Difficulty (low/mid/high)</option>
                </select>
            </div>
            <div class="form-group">
                <label for="newValue" class="form-label mt-4">Please enter your changes here: </label>

                <input type="text" id="newValue" name="newValue" class="form-control" rows="3"/>
            </div>
            <div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </div>
        <div class="col-sm-4"></div>
    </div>
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
