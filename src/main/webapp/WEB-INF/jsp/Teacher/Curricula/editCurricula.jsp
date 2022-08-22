<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 19/8/2022
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url var="validationJs" value="/js/user-validation.js" />
<script src="${validationJs}"></script>

<c:url var="formAction" value="/Curricula/edit/${curricula.curriculaId}" />
<form method="POST" action="${formAction}">
  <input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
  <div class="row">
    <div class="col-sm-4"></div>
    <div class="col-sm-4">

      <div class="form-group">
       <p>Curricula id: ${curricula.curriculaId}</p>
      </div>
      <div class="form-group">
        <label for="updateCriteria"> Please select the field you want to edit: </label>
        <select  id="updateCriteria" name="updateCriteria"  class="form-control">
          <option value="" selected disabled>Please select an option</option>
          <option value="name">Curricula Name</option>
          <option value="instruction">Daily Instruction</option>
          <option value="homework">Daily Homework</option>
        </select>
      </div>
      <div class="form-group">
        <label for="newValue">Please enter your changes here: </label>
        <input type="text" id="newValue" name="newValue"  class="form-control" />
      </div>

      <button type="submit" class="btn btn-primary">Submit</button>
    </div>
    <div class="col-sm-4"></div>
  </div>
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />




