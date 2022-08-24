<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<c:url var="validationJs" value="/js/user-validation.js"/>
<script src="${validationJs}"></script>

<c:url var="formAction" value="/gradeHomework/${homeworkId}"/>
<form method="POST" action="${formAction}">
    <input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <div class="form-group">
                <h2>Review Homework</h2>
                <div class="form-group">
                    <label for="grade" class="form-label mt-4">Select homework grading</label>
                    <select class="form-select" id="grade" type="number" name="grade">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="status">Status: </label>
                    <select id="status" name="status" class="form-control">
                        <option value="" selected disabled>Please select the status of the homework:</option>
                        <option value="completed">Completed</option>
                        <option value="incomplete">Incomplete</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="teacherFeedback" class="form-label mt-4"> Feedback: </label>
                <input type="text" id="teacherFeedback" name="teacherFeedback" placeHolder=" Comment"
                       class="form-control"/>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
        <div class="col-sm-4"></div>
    </div>
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
