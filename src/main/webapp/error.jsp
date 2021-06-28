<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="lang"/>
<jsp:include page="header.jsp"/>
<body>
<div class="jumbotron p-3 p-md-5 text-white rounded bg-danger">
    <div class="col-md-6 px-0">
        <h1 class="display-4 font-italic"><fmt:message key="error"/></h1>
    </div>
</div>
</body>

