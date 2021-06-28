<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="lang"/>
<!DOCTYPE html>
<html lang="${language}">
<head>
    <jsp:include page="links.jsp"/>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/DeliveryController/main"><fmt:message key="home"/><span class="sr-only">(current)</span></a>
            </li>
            <c:if test='${sessionScope.id == null}'>
            <li class="nav-item">
                <a class="nav-link" href="/login.jsp"><fmt:message key="signin"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/registration.jsp"><fmt:message key="registration"/></a>
            </li>
            </c:if>
            <c:if test='${sessionScope.id != null}'>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                        ${sessionScope.name}
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <c:if test='${sessionScope.status == 1}'>
                    <a class="dropdown-item" href="/DeliveryController/my_history"><fmt:message key="history"/></a>
                    <a class="dropdown-item" href="/DeliveryController/my_basket"><fmt:message key="basket"/></a>
                    <div class="dropdown-divider"></div>
                    </c:if>
                    <a class="dropdown-item" href="/DeliveryController/logout"><fmt:message key="logout"/></a>
                </div>
            </li>
            </c:if>
            <li class="nav-item">
                <form class="form-inline">
                    <div class="form-group">
                        <select class="form-control" id="language" name="language" onchange="submit()">
                            <option value="ru" ${language == 'ru' ? 'selected' : ''}>Ru</option>
                            <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                        </select>
                    </div>
                </form>
            </li>
        </ul>
    </div>
</nav>
<c:if test='${message != null}'>
    <div class="alert alert-primary" role="alert">
            ${message}
    </div>
</c:if>
</body>
</html>