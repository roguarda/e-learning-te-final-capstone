<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../common/header.jsp">
  <c:param name="title" value="Person: Edit"/>
</c:import>


<c:url var="editUrl" value="/people/edit/${Profile.id}"/>
<form method="post" action="${editUrl}" class="detail-container">

  <div class="form-group">
    <label for="userName">User Name: </label>
    <input type="text" id="userName" name="userName" placeHolder="User Name" class="form-control" />
  </div>
  <div class="form-group">
    <label for="password">Password: </label>
    <input type="password" id="password" name="password" placeHolder="Password" class="form-control" />
  </div>
  <%--<div class="form-group">
    <label for="email">Email: </label>
    <input type="email" id="email" name="email" placeHolder="Email" class="form-control" />
  </div>--%>
  <div class="form-group">
    <label for="confirmPassword">Confirm Password: </label>
    <input type="password" id="confirmPassword" name="confirmPassword" placeHolder="Re-Type Password" class="form-control" />
  </div>
  <div class="form-group">
    <label for="firstName">First Name: </label>
    <input type="text" id="firstName" name="firstName" placeHolder="Name" class="form-control" />
  </div>
  <div class="form-group">
    <label for="lastName">Last Name: </label>
    <input type="text" id="lastName" name="lastName" placeHolder="Last Name" class="form-control" />
  </div>

    <div class="detail-value">
      <input type="submit" value="Update">
    </div>
  </div>

  <button type="submit" class="btn btn-primary">Create User</button>
  </div>
  <div class="col-sm-4"></div>
  </div>
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />