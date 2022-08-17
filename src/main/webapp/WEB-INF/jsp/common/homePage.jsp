<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<div class="text">
    <c:url var="home" value="/img/homephoto.png" />
    <img src="${home}" class="img-fluid" alt="fallo de nuevo">
</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />