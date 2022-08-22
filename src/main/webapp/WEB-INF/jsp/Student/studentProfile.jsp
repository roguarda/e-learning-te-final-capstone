<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:import url="/WEB-INF/jsp/common/header.jsp"/>


<form method="POST" action="${formAction}">
<input type="hidden" name="TOKEN" value="${TOKEN}"/>
<h2>Your profile</h2>

<c:url value="/studentHomePage/Profile" var="Profile" />
<%--@elvariable id="YourProfile" type=""--%>

<form:form action="${register}" method="POST" modelAttribute="RegisterProfile">

  <div class="detail-container">
  </div>
  <div class="detail-row">
    <div class="detail-header">
      ID
    </div>
    <div class="detail-value">
        ${user.userId}
    </div>
  </div>
    <div class="detail-row">
      <div class="detail-header">
        First Name
      </div>
      <div class="detail-value">
          ${user.firstName}
      </div>
    </div>
    <div class="detail-row">
      <div class="detail-header">
        Last Name
      </div>
      <div class="detail-value">
          ${user.lastName}
      </div>
    </div>
  <div class="detail-row">
    <div class="detail-header">
    <%--  Email
    </div>
    <div class="detail-value">
        ${user.Email}
    </div>
  </div>--%>



  <div class="detail-row">
      <c:url var="editLink" value="/Profile/edit/${currentUser.userId}" />
    <a href="${editLink}" class="edit-link">Edit</a>


  </div>
  </div>




<%--
    <div class="row">
      <div class="col-sm-4"></div>
      <div class="col-sm-4">
        <div class="form-group">
          <label for="userName">User Name: </label>
          <input type="text" id="userName" name="userName" placeHolder="User Name" class="form-control" />
        </div>
        <div class="form-group">
          <label for="password">Password: </label>
          <input type="password" id="password" name="password" placeHolder="Password" class="form-control" />
        </div>
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
        <div class="form-group">
          <label for="role">Role: </label>
          <select  id="role" name="role"  class="form-control">
            <option value="" selected disabled>Please select a role</option>
            <option value="teacher">Teacher</option>
            <option value="student">Student</option>





  <div>
      &lt;%&ndash;@declare id="name"&ndash;%&gt;<label for="Name"> Name</label>
    <form:input  path="name" class="form-control"/>
    <form:errors path="name" cssClass="error"/>
  </div>
  <div>
      &lt;%&ndash;@declare id="age"&ndash;%&gt;<label for="Age">Age</label>
    <form:input  path="age" class="form-control" />
    <form:errors path="age" cssClass="error"/>
  </div>
  <div>
      &lt;%&ndash;@declare id="Email"&ndash;%&gt;<label for="Email">Email</label>
    <form:input  path="Email" class="form-control" />
    <form:errors path="Email" cssClass="error"/>


  </div>--%>

  </form>

</form:form>

<%@include file="../common/footer.jsp" %>
