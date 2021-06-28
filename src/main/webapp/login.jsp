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
<div class="container">
    <form action="DeliveryController/login">
        <div class="form-group">
            <label for="exampleInputEmail1"><fmt:message key="email"/></label>
            <fmt:message key="email" var="email" />
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                   placeholder="${email}" name="email" required>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1"><fmt:message key="password"/></label>
            <fmt:message key="password" var="password" />
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="${password}" name="password" required>
        </div>
        <button type="submit" class="btn btn-primary"><fmt:message key="signin"/></button>
    </form>
</div>
</body>
