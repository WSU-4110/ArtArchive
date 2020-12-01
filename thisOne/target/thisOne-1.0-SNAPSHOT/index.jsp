<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<title>AA - Login</title>
<%@ include file="WEB-INF/head.html" %>
<header><h1>ART ARCHIVE - Login</h1></header>

<body>
<%@ include file="WEB-INF/navbar.html" %>
	<div class="container">
	<div class="head">
	<h1>Login</h1>
	</div>
    <div align="center" class="info">
     	<form action="Login" method="post">
        <table border="1" cellpadding="5">   
            <tr>
                <th>Username:</th>
                <td>
                    <input type="text" name="username" size="45" value="" required/>
                </td>
            </tr>
            <tr>
                <th>Password:</th>
                <td>
                    <input type="password" name="password" size="45" value="" required/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Login" />
                </td>
            </tr>
        </table>
        </form>
    </div>
    </div>
</body>
</html>