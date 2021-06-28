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
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col"><fmt:message key="type"/></th>
        <th scope="col"><fmt:message key="data"/></th>
        <th scope="col"><fmt:message key="price"/></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="Reciept" varStatus="index" items="${reciepts}">
        <tr>
            <th scope="row">${index.index + 1}</th>
            <c:if test='${Reciept.getType() == 1}'>
                <td><fmt:message key="card"/></td>
            </c:if>
            <c:if test='${Reciept.getType() == 2}'>
                <td><fmt:message key="cash"/></td>
            </c:if>
            <td>${Reciept.getTime()}</td>
            <td>${Reciept.getAllPrice()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>

