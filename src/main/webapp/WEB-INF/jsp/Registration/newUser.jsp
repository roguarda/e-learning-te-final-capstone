<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url var="validationJs" value="/js/user-validation.js" />
<script src="${validationJs}"></script>

<c:url var="formAction" value="/users" />
<form method="POST" action="${formAction}">
<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
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
				<label for="email">Email: </label>
				<input type="email" id="email" name="email" placeHolder="Email" class="form-control" />
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

				</select>
			</div>

			<button type="submit" class="btn btn-primary">Create User</button>
		</div>
		<div class="col-sm-4"></div>
	</div>
</form>
		
<c:import url="/WEB-INF/jsp/common/footer.jsp" />