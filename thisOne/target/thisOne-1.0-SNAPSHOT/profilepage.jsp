<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="WEB-INF/styles.css" rel="stylesheet" type="text/css">
<html>
<title>Profile Page</title>
<%@ include file="WEB-INF/head.html" %>

<body>
<%@ include file="WEB-INF/navbar.html" %>
<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 background-color: white; sidenav">
            <img src="l60Hf.png" class="img-circle" alt="Profile Picture Test" width="100" height="100">
            <h1> test</h1>
            <c:forEach var="user" items="${listProfileUser}">
                <tr>
                    <td><c:out value="${user.firstName}" /></td>
                </tr>
            </c:forEach>
            <c:forEach var="user" items="${listProfileUser}">
                <tr>
                    <td><c:out value="${user.lastName}" /></td>
                </tr>
            </c:forEach>
            <a href="edit">Edit</a>
            <c:forEach var="user" items="${listProfileUser}">
                <tr>
                    <td><c:out value="${user.description}" /></td>
                </tr>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>