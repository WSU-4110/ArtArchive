<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="WEB-INF/styles.css" rel="stylesheet" type="text/css">
<html>
<header><h1>ART ARCHIVE - Profile Page</h1></header>
<%@ include file="WEB-INF/head.html" %>
<style>
:root {
--main-bg-color: <c:forEach var="user" items="${listProfileUser}"><c:out value="${user.favoriteColor}"/> </c:forEach>;
}
.one {
background-color: var(--main-bg-color);
width: 18rem;
padding: 50px;
margin: 35px;
border-radius: 25px;
.mx-auto;
}
</style>
<body>
<%@ include file="WEB-INF/navbar.html" %>
<div class="one">
<div class="card">
    <img class="card-img-top">
    <c:forEach var="user" items="${listProfileUser}">
        <iframe src="<c:out value="${user.file}" />"></iframe>
    </c:forEach>
    <div class="card-body">
            <c:forEach var="user" items="${listProfileUser}">
                <h5 class="card-title"> <c:out value="${user.firstName}" /> <c:out value="${user.lastName}" /> </h5>
            </c:forEach>
            <a href="edit" class="card-link">Edit</a>
            <c:forEach var="user" items="${listProfileUser}">
                    <p class="card-text"><c:out value="${user.description}" /></p>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>