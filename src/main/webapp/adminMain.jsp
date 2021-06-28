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
<div class="jumbotron p-3 p-md-5 text-white rounded bg-dark">
    <div class="col-md-6 px-0">
        <h1 class="display-4 font-italic"><fmt:message key="Teg"/></h1>
    </div>
</div>
<form class="col-md-12" action="${pageContext.request.contextPath}/DeliveryController/teg/create">
    <div class="card flex-md-row mb-4 shadow-sm">
        <div class="card-body d-flex flex-column align-items-start h-md-250">
            <strong class="d-inline-block mb-2 text-success"><fmt:message key="create"/> <fmt:message
                    key="Teg"/></strong>
            <div>
                <div class="row">
                    <div class="col">
                        <p><fmt:message key="name"/>:</p>
                        <input type="text" name="name" class="form-control" required>
                        <br>
                        <button type="submit" class="btn btn-primary" style="width: 200px"><fmt:message
                                key="create"/> <fmt:message key="Teg"/></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<c:forEach var="teg" items="${Tegs}">
    <div class="col-md-12">
        <div class="card flex-md-row mb-4 shadow-sm h-md-250">
            <div class="card-body d-flex flex-column align-items-start">
                <strong class="d-inline-block mb-2 text-success">Id - ${teg.getId()}</strong>
                <form action="${pageContext.request.contextPath}/DeliveryController/teg/update">
                    <input type="hidden" name="id" class="form-control" value="${teg.getId()}">
                    <h3 class="mb-0">
                        <input type="text" name="name" class="form-control" value="${teg.getName()}">
                    </h3>
                    <br>
                    <button type="submit" class="btn btn-info" style="width: 200px"><fmt:message
                            key="update"/> <fmt:message key="Teg"/></button>
                </form>
                <br>
                <form action="${pageContext.request.contextPath}/DeliveryController/teg/delete">
                    <input type="hidden" name="id" class="form-control" value="${teg.getId()}">
                    <button type="submit" class="btn btn-danger" style="width: 200px"><fmt:message
                            key="delete"/> <fmt:message key="Teg"/></button>
                </form>
            </div>
        </div>
    </div>
</c:forEach>
<div class="jumbotron p-3 p-md-5 text-white rounded bg-dark">
    <div class="col-md-6 px-0">
        <h1 class="display-4 font-italic"><fmt:message key="product"/></h1>
    </div>
</div>
<form class="col-md-12" action="${pageContext.request.contextPath}/DeliveryController/product/create">
    <div class="card flex-md-row mb-4 shadow-sm">
        <div class="card-body d-flex flex-column align-items-start h-md-250">
            <strong class="d-inline-block mb-2 text-success"><fmt:message key="create"/> <fmt:message
                    key="product"/></strong>
            <div>
                <div class="row">
                    <div class="col">
                        <p><fmt:message key="name"/>:</p>
                        <input type="text" name="name" class="form-control" required>
                        <br>
                        <p><fmt:message key="type"/>:</p>
                        <select class="custom-select" name="type">
                            <option value="1" selected><fmt:message key="burger"/></option>
                            <option value="2"><fmt:message key="pizza"/></option>
                            <option value="3"><fmt:message key="drinks"/></option>
                            <option value="4"><fmt:message key="salat"/></option>
                            <option value="5"><fmt:message key="addition"/></option>
                        </select>
                        <br>
                        <p><fmt:message key="description"/>:</p>
                        <input type="text" name="description" class="form-control" required>
                        <br>
                        <p><fmt:message key="photo"/>:</p>
                        <input type="text" name="photo" class="form-control" required>
                        <br>
                        <p><fmt:message key="price"/>:</p>
                        <input type="number" name="price" class="form-control" required>
                        <br>
                        <button type="submit" class="btn btn-primary" style="width: 200px"><fmt:message
                                key="create"/> <fmt:message key="Teg"/></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<c:forEach var="Products" items="${productsAndTheirTegs}">
    <div class="col-md-12">
        <div class="card flex-md-row mb-4 shadow-sm h-md-250">
            <div class="card-body d-flex flex-column align-items-start">
                <strong class="d-inline-block mb-2 text-success">Id - ${Products.key.getId()}</strong>
                <form action="${pageContext.request.contextPath}/DeliveryController/product/update">
                    <input type="hidden" name="id" class="form-control" value="${Products.key.getId()}">
                    <h3 class="mb-2">
                        <p><fmt:message key="name"/>:</p>
                        <input type="text" name="name" class="form-control" value="${Products.key.getName()}">
                    </h3>
                    <br>
                    <p><fmt:message key="type"/>:</p>
                    <select class="custom-select" name="type">
                        <c:if test='${Products.key.getType_id() == 1}'>
                            <option value="1" selected><fmt:message key="burger"/></option>
                            <option value="2"><fmt:message key="pizza"/></option>
                            <option value="3"><fmt:message key="drinks"/></option>
                            <option value="4"><fmt:message key="salat"/></option>
                            <option value="5"><fmt:message key="addition"/></option>
                        </c:if>
                        <c:if test='${Products.key.getType_id() == 2}'>
                            <option value="1"><fmt:message key="burger"/></option>
                            <option value="2" selected><fmt:message key="pizza"/></option>
                            <option value="3"><fmt:message key="drinks"/></option>
                            <option value="4"><fmt:message key="salat"/></option>
                            <option value="5"><fmt:message key="addition"/></option>
                        </c:if>
                        <c:if test='${Products.key.getType_id() == 3}'>
                            <option value="1"><fmt:message key="burger"/></option>
                            <option value="2"><fmt:message key="pizza"/></option>
                            <option value="3" selected><fmt:message key="drinks"/></option>
                            <option value="4"><fmt:message key="salat"/></option>
                            <option value="5"><fmt:message key="addition"/></option>
                        </c:if>
                        <c:if test='${Products.key.getType_id() == 4}'>
                            <option value="1"><fmt:message key="burger"/></option>
                            <option value="2"><fmt:message key="pizza"/></option>
                            <option value="3"><fmt:message key="drinks"/></option>
                            <option value="4" selected><fmt:message key="salat"/></option>
                            <option value="5"><fmt:message key="addition"/></option>
                        </c:if>
                        <c:if test='${Products.key.getType_id() == 5}'>
                            <option value="1"><fmt:message key="burger"/></option>
                            <option value="2"><fmt:message key="pizza"/></option>
                            <option value="3"><fmt:message key="drinks"/></option>
                            <option value="4"><fmt:message key="salat"/></option>
                            <option value="5" selected><fmt:message key="addition"/></option>
                        </c:if>
                    </select>
                    <br>
                    <h3 class="mb-0">
                        <p><fmt:message key="description"/>:</p>
                        <input type="text" name="description" class="form-control"
                               value="${Products.key.getDescription()}">
                    </h3>
                    <br>
                    <h3 class="mb-0">
                        <p><fmt:message key="photo"/>:</p>
                        <input type="text" name="photo" class="form-control" value="${Products.key.getPhoto_link()}">
                    </h3>
                    <br>
                    <h3 class="mb-0">
                        <p><fmt:message key="price"/>:</p>
                        <input type="number" name="price" class="form-control" value="${Products.key.getPrice()}">
                    </h3>
                    <br>
                    <button type="submit" class="btn btn-info" style="width: 200px"><fmt:message
                            key="update"/> <fmt:message key="product"/></button>
                </form>
                <br>
                <form action="${pageContext.request.contextPath}/DeliveryController/product/teg/add">
                    <input type="hidden" name="id" class="form-control" value="${Products.key.getId()}">
                    <p><fmt:message key="tegAdd"/>:</p>
                    <select class="custom-select" name="teg">
                        <c:forEach var="teg" items="${Tegs}">
                            <option value="${teg.getId()}"> ${teg.getName()}</option>
                        </c:forEach>
                    </select>
                    <button type="submit" class="btn btn-primary" style="width: 200px"><fmt:message
                            key="create"/></button>
                </form>
                <form action="${pageContext.request.contextPath}/DeliveryController/product/teg/delete">
                    <input type="hidden" name="id" class="form-control" value="${Products.key.getId()}">
                    <p><fmt:message key="tegDelete"/>:</p>
                    <select class="custom-select" name="teg">
                        <c:forEach var="Tegs" items="${Products.value}">
                            <option value="${Tegs.getId()}"> ${Tegs.getName()}</option>
                        </c:forEach>
                    </select>
                    <button type="submit" class="btn btn-danger" style="width: 200px"><fmt:message
                            key="delete"/></button>
                </form>
                <br>
                <form action="${pageContext.request.contextPath}/DeliveryController/product/delete">
                    <input type="hidden" name="id" class="form-control" value="${Products.key.getId()}">
                    <button type="submit" class="btn btn-danger" style="width: 200px"><fmt:message
                            key="delete"/> <fmt:message key="product"/></button>
                </form>
            </div>
        </div>
    </div>
</c:forEach>
</body>

