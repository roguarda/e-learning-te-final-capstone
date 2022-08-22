<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:import url="/WEB-INF/jsp/common/header.jsp" />



<c:url var="formAction" value="/Profile/edit/${currentUser.userName}"/>
<form method="POST" action="${formAction}" >
  <input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
  <div class="row">
    <div class="col-sm-3"></div>
    <div class="col-sm-3">

      <div class="form-group">
        <p>User id: ${currentUser.userId}</p>
      </div>
      <div class="form-group">
        <label for="updateUser"> Please select the field you want to edit: </label>
        <select  id="updateUser" name="updateUser"  class="form-control">
          <option value="" selected disabled>Please select an option</option>
          <option value="firstName">First Name</option>
          <option value="lastName">Last Name</option>
        </select>
      </div>
      <div class="form-group">
        <label for="newValue">Please enter your changes here: </label>
        <input type="text" id="newValue" name="newValue"  class="form-control" />
      </div>

      <button type="submit" class="btn btn-primary">Submit</button>
    </div>
    <div class="col-sm-3"></div>
  </div>
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />