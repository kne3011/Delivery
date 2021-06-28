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
        <th scope="col"><fmt:message key="name"/></th>
        <th scope="col"><fmt:message key="price"/></th>
        <th scope="col"><fmt:message key="count"/></th>
    </tr>
    </thead>
    <tbody>
<c:forEach var="Product" varStatus="index" items="${products}">
    <tr>
        <th scope="row">${index.index + 1}</th>
        <td>${Product.key.getName()}</td>
        <td>${Product.key.getPrice() * Product.value}</td>
        <td>${Product.value}</td>
    </tr>
</c:forEach>
    </tbody>
</table>
<form action="${pageContext.request.contextPath}/DeliveryController/buy">
    <select class="custom-select" name="type">
        <option value="1" selected><fmt:message key="card"/></option>
        <option value="2"><fmt:message key="cash"/></option>
    </select>
    <button type="submit" class="btn btn-info" style="width: 200px"><fmt:message
            key="add"/></button>
    <br>
</form>
<br>
<form action="${pageContext.request.contextPath}/DeliveryController/clearBasket">
    <button type="submit" class="btn btn-info" style="width: 200px"><fmt:message
            key="delete"/></button>
    <br>
</form>
</body>

