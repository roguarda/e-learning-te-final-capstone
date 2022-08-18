<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<c:import url="/WEB-INF/jsp/common/header.jsp"/>


<form method="POST" action="${formAction}">
<input type="hidden" name="TOKEN" value="${TOKEN}"/>
    <h2>Edit/View you profile</h2>

    <c:url value="/studentHomePage/Profile" var="Profile" />
    <%--@elvariable id="RegisterProfile" type=""--%>
    <form:form action="${register}" method="POST" modelAttribute="RegisterProfile">

    <div>
            <%--@declare id="name"--%><label for="Name"> Name</label>
        <form:input  path="name" class="form-control"/>
        <form:errors path="name" cssClass="error"/>
    </div>
    <div>
            <%--@declare id="age"--%><label for="Age">Age</label>
        <form:input  path="age" class="form-control" />
        <form:errors path="age" cssClass="error"/>
    </div>
    <div>
            <%--@declare id="Email"--%><label for="Email">Email</label>
                <form:input  path="Email" class="form-control" />
                <form:errors path="Email" cssClass="error"/>

       
        </div>

    </form>
    
    </form:form>

<%@include file="../common/footer.jsp" %>