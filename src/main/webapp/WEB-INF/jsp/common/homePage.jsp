<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<div class="text">
    <c:url var="home" value="/img/homephoto.png" />
    <img align="center" src="${home}" class="img-fluid" alt="Welcome!">
</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />