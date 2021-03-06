<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
     <c:set var = "ID" scope = "session" value = "${userRole_id}"/>
    <c:choose>
    <c:when test="${ID==1}">
    <%@ include file="include/menuAdmin.htm" %>
    </c:when>
    <c:when test="${ID==2}">
    <%@ include file="include/menuUser.htm" %>
    </c:when>
    <c:otherwise>
    <%@ include file="include/menu.htm" %>
    </c:otherwise>
    </c:choose>
    <div class="page-header">
        <h1>Все объявления</h1>
    </div>

    <div class="row">
        <div class="col-md-1">Цена</div>
        <div class="col-md-3">Адрес</div>
        <div class="col-md-4">Описание</div>
        <div class="col-md-1">Число комнат</div>
        <div class="col-md-1">Площадь</div>
        <div class="col-md-1">Этаж</div>
        <div class="col-md-1">Этажность</div>

    </div>

    <c:forEach items="${ads}" var="ad">
        <div class="row">
            <div class="col-md-1">${ad.price} </div>
            <div class="col-md-3">${ad.adress} </div>
            <div class="col-md-4">${ad.description} </div>
            <div class="col-md-1">${ad.rooms} </div>
            <div class="col-md-1">${ad.area} </div>
            <div class="col-md-1">${ad.flat} </div>
            <div class="col-md-1">${ad.flats} </div>
        </div>
    </c:forEach>

    <br><br>
</div>
</body>
</html>
