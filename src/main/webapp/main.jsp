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
<form action="${pageContext.request.contextPath}/DeliveryController/search">
    <select class="custom-select" name="teg">
        <c:forEach var="teg" items="${Tegs}">
            <option value="${teg.getId()}"> ${teg.getName()}</option>
        </c:forEach>
    </select>
    <br>
    <button type="submit" class="btn btn-primary" style="width: 200px"><fmt:message
            key="search"/></button>
</form>
<br>
<br>
<div class="jumbotron p-3 p-md-5 text-white rounded bg-dark">
    <div class="col-md-6 px-0">
        <h1 class="display-4 font-italic"><fmt:message key="burger"/></h1>
    </div>
</div>
<c:forEach var="Products" items="${productsAndTheirTegs}">
    <c:if test='${Products.key.getType_id() == 1}'>
        <div class="col-md-12">
            <div class="card flex-md-row mb-4 shadow-sm h-md-250">
                <div class="card-body d-flex flex-column align-items-start">
                    <strong class="d-inline-block mb-2 text-success">Id - ${Products.key.getId()}</strong>
                    <h3 class="mb-2">
                        <p><fmt:message key="name"/>:</p>
                        <strong class="d-inline-block mb-2 text-primary">${Products.key.getName()}</strong>
                    </h3>
                    <br>
                    <h3 class="mb-0">
                        <p><fmt:message key="description"/>:</p>
                        <strong class="d-inline-block mb-2 text-primary">${Products.key.getDescription()}</strong>
                    </h3>
                    <br>
                    <h3 class="mb-0">
                        <p><fmt:message key="photo"/>:</p>
                        <img src="${Products.key.getPhoto_link()}" class="img-thumbnail">
                    </h3>
                    <br>
                    <h3 class="mb-0">
                        <p><fmt:message key="price"/>:</p>
                        <strong class="d-inline-block mb-2 text-primary">${Products.key.getPrice()}</strong>
                    </h3>
                    <br>
                    <c:if test='${sessionScope.id != null}'>
                        <form action="${pageContext.request.contextPath}/DeliveryController/addToCurt">
                            <input type="hidden" name="id" class="form-control" value="${Products.key.getId()}">
                            <input type="hidden" name="name" class="form-control" value="${Products.key.getName()}">
                            <button type="submit" class="btn btn-info" style="width: 200px"><fmt:message
                                    key="add"/> <fmt:message key="product"/></button>
                            <br>
                        </form>
                    </c:if>
                    <p><fmt:message key="Teg"/>:</p>
                    <strong class="d-inline-block mb-2 text-primary">
                        <c:forEach var="Tegs" items="${Products.value}">
                            ${Tegs.getName()}
                        </c:forEach>
                    </strong>
                </div>
            </div>
        </div>
    </c:if>
</c:forEach>
<div class="jumbotron p-3 p-md-5 text-white rounded bg-dark">
    <div class="col-md-6 px-0">
        <h1 class="display-4 font-italic"><fmt:message key="pizza"/></h1>
    </div>
</div>
<c:forEach var="Products" items="${productsAndTheirTegs}">
    <c:if test='${Products.key.getType_id() == 2}'>
        <div class="col-md-12">
            <div class="card flex-md-row mb-4 shadow-sm h-md-250">
                <div class="card-body d-flex flex-column align-items-start">
                    <strong class="d-inline-block mb-2 text-success">Id - ${Products.key.getId()}</strong>
                    <h3 class="mb-2">
                        <p><fmt:message key="name"/>:</p>
                        <strong class="d-inline-block mb-2 text-primary">${Products.key.getName()}</strong>
                    </h3>
                    <br>
                    <h3 class="mb-0">
                        <p><fmt:message key="description"/>:</p>
                        <strong class="d-inline-block mb-2 text-primary">${Products.key.getDescription()}</strong>
                    </h3>
                    <br>
                    <h3 class="mb-0">
                        <p><fmt:message key="photo"/>:</p>
                        <img src="${Products.key.getPhoto_link()}" class="img-thumbnail">
                    </h3>
                    <br>
                    <h3 class="mb-0">
                        <p><fmt:message key="price"/>:</p>
                        <strong class="d-inline-block mb-2 text-primary">${Products.key.getPrice()}</strong>
                    </h3>
                    <br>
                    <c:if test='${sessionScope.id != null}'>
                        <form action="${pageContext.request.contextPath}/DeliveryController/addToCurt">
                            <input type="hidden" name="id" class="form-control" value="${Products.key.getId()}">
                            <input type="hidden" name="name" class="form-control" value="${Products.key.getName()}">
                            <button type="submit" class="btn btn-info" style="width: 200px"><fmt:message
                                    key="add"/> <fmt:message key="product"/></button>
                            <br>
                        </form>
                    </c:if>
                    <p><fmt:message key="Teg"/>:</p>
                    <strong class="d-inline-block mb-2 text-primary">
                        <c:forEach var="Tegs" items="${Products.value}">
                            ${Tegs.getName()}
                        </c:forEach>
                    </strong>
                </div>
            </div>
        </div>
    </c:if>
</c:forEach>
<div class="jumbotron p-3 p-md-5 text-white rounded bg-dark">
    <div class="col-md-6 px-0">
        <h1 class="display-4 font-italic"><fmt:message key="drinks"/></h1>
    </div>
</div>
<c:forEach var="Products" items="${productsAndTheirTegs}">
    <c:if test='${Products.key.getType_id() == 3}'>
        <div class="col-md-12">
            <div class="card flex-md-row mb-4 shadow-sm h-md-250">
                <div class="card-body d-flex flex-column align-items-start">
                    <strong class="d-inline-block mb-2 text-success">Id - ${Products.key.getId()}</strong>
                    <h3 class="mb-2">
                        <p><fmt:message key="name"/>:</p>
                        <strong class="d-inline-block mb-2 text-primary">${Products.key.getName()}</strong>
                    </h3>
                    <br>
                    <h3 class="mb-0">
                        <p><fmt:message key="description"/>:</p>
                        <strong class="d-inline-block mb-2 text-primary">${Products.key.getDescription()}</strong>
                    </h3>
                    <br>
                    <h3 class="mb-0">
                        <p><fmt:message key="photo"/>:</p>
                        <img src="${Products.key.getPhoto_link()}" class="img-thumbnail">
                    </h3>
                    <br>
                    <h3 class="mb-0">
                        <p><fmt:message key="price"/>:</p>
                        <strong class="d-inline-block mb-2 text-primary">${Products.key.getPrice()}</strong>
                    </h3>
                    <br>
                    <c:if test='${sessionScope.id != null}'>
                        <form action="${pageContext.request.contextPath}/DeliveryController/addToCurt">
                            <input type="hidden" name="id" class="form-control" value="${Products.key.getId()}">
                            <input type="hidden" name="name" class="form-control" value="${Products.key.getName()}">
                            <button type="submit" class="btn btn-info" style="width: 200px"><fmt:message
                                    key="add"/> <fmt:message key="product"/></button>
                            <br>
                        </form>
                    </c:if>
                    <p><fmt:message key="Teg"/>:</p>
                    <strong class="d-inline-block mb-2 text-primary">
                        <c:forEach var="Tegs" items="${Products.value}">
                            ${Tegs.getName()}
                        </c:forEach>
                    </strong>
                </div>
            </div>
        </div>
    </c:if>
</c:forEach>
<div class="jumbotron p-3 p-md-5 text-white rounded bg-dark">
    <div class="col-md-6 px-0">
        <h1 class="display-4 font-italic"><fmt:message key="salat"/></h1>
    </div>
</div>
<c:forEach var="Products" items="${productsAndTheirTegs}">
    <c:if test='${Products.key.getType_id() == 4}'>
        <div class="col-md-12">
            <div class="card flex-md-row mb-4 shadow-sm h-md-250">
                <div class="card-body d-flex flex-column align-items-start">
                    <strong class="d-inline-block mb-2 text-success">Id - ${Products.key.getId()}</strong>
                    <h3 class="mb-2">
                        <p><fmt:message key="name"/>:</p>
                        <strong class="d-inline-block mb-2 text-primary">${Products.key.getName()}</strong>
                    </h3>
                    <br>
                    <h3 class="mb-0">
                        <p><fmt:message key="description"/>:</p>
                        <strong class="d-inline-block mb-2 text-primary">${Products.key.getDescription()}</strong>
                    </h3>
                    <br>
                    <h3 class="mb-0">
                        <p><fmt:message key="photo"/>:</p>
                        <img src="${Products.key.getPhoto_link()}" class="img-thumbnail">
                    </h3>
                    <br>
                    <h3 class="mb-0">
                        <p><fmt:message key="price"/>:</p>
                        <strong class="d-inline-block mb-2 text-primary">${Products.key.getPrice()}</strong>
                    </h3>
                    <br>
                    <c:if test='${sessionScope.id != null}'>
                        <form action="${pageContext.request.contextPath}/DeliveryController/addToCurt">
                            <input type="hidden" name="id" class="form-control" value="${Products.key.getId()}">
                            <input type="hidden" name="name" class="form-control" value="${Products.key.getName()}">
                            <button type="submit" class="btn btn-info" style="width: 200px"><fmt:message
                                    key="add"/> <fmt:message key="product"/></button>
                            <br>
                        </form>
                    </c:if>
                    <p><fmt:message key="Teg"/>:</p>
                    <strong class="d-inline-block mb-2 text-primary">
                        <c:forEach var="Tegs" items="${Products.value}">
                            ${Tegs.getName()}
                        </c:forEach>
                    </strong>
                </div>
            </div>
        </div>
    </c:if>
</c:forEach>
<div class="jumbotron p-3 p-md-5 text-white rounded bg-dark">
    <div class="col-md-6 px-0">
        <h1 class="display-4 font-italic"><fmt:message key="addition"/></h1>
    </div>
</div>
<c:forEach var="Products" items="${productsAndTheirTegs}">
    <c:if test='${Products.key.getType_id() == 5}'>
        <div class="col-md-12">
            <div class="card flex-md-row mb-4 shadow-sm h-md-250">
                <div class="card-body d-flex flex-column align-items-start">
                    <strong class="d-inline-block mb-2 text-success">Id - ${Products.key.getId()}</strong>
                    <h3 class="mb-2">
                        <p><fmt:message key="name"/>:</p>
                        <strong class="d-inline-block mb-2 text-primary">${Products.key.getName()}</strong>
                    </h3>
                    <br>
                    <h3 class="mb-0">
                        <p><fmt:message key="description"/>:</p>
                        <strong class="d-inline-block mb-2 text-primary">${Products.key.getDescription()}</strong>
                    </h3>
                    <br>
                    <h3 class="mb-0">
                        <p><fmt:message key="photo"/>:</p>
                        <img src="${Products.key.getPhoto_link()}" class="img-thumbnail">
                    </h3>
                    <br>
                    <h3 class="mb-0">
                        <p><fmt:message key="price"/>:</p>
                        <strong class="d-inline-block mb-2 text-primary">${Products.key.getPrice()}</strong>
                    </h3>
                    <br>
                    <c:if test='${sessionScope.id != null}'>
                        <form action="${pageContext.request.contextPath}/DeliveryController/addToCurt">
                            <input type="hidden" name="id" class="form-control" value="${Products.key.getId()}">
                            <input type="hidden" name="name" class="form-control" value="${Products.key.getName()}">
                            <button type="submit" class="btn btn-info" style="width: 200px"><fmt:message
                                    key="add"/> <fmt:message key="product"/></button>
                            <br>
                        </form>
                    </c:if>
                    <p><fmt:message key="Teg"/>:</p>
                    <strong class="d-inline-block mb-2 text-primary">
                        <c:forEach var="Tegs" items="${Products.value}">
                            ${Tegs.getName()}
                        </c:forEach>
                    </strong>
                </div>
            </div>
        </div>
    </c:if>
</c:forEach>
</body>

