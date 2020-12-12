<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@ include file="WEB-INF/head.html" %>
<head>
	<title>User Management Application</title>
</head>
<body>
	<center>
		<h1>User Management</h1>
        <h2>
        	<a href="register">Add New User</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Users</a>
        </h2>
	</center>
    <div align="center">
		<c:if test="${user != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${user == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
        		<c:if test="${user != null}">
        			<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
        		</c:if>            
            <tr>
                <th>User Name: </th>
                <td>
                	<input type="text" name="name" size="45"
                			value="<c:out value='${user.name}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>User Email: </th>
                <td>
                	<input type="text" name="email" size="45"
                			value="<c:out value='${user.email}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Country: </th>
                <td>
                	<input type="text" name="country" size="15"
                			value="<c:out value='${user.country}' />"
                	/>
                </td>
            </tr>
			<tr>
				<th>Password: </th>
				<td>
					<input type="text" name="password" size="15"
						   value="<c:out value='${user.password}' />"
					/>
				</td>
			</tr>
			<tr>
				<th>First Name: </th>
				<td>
					<input type="text" name="firstName" size="15"
						   value="<c:out value='${user.firstName}' />"
					/>
				</td>
			</tr>
			<tr>
				<th>Last Name: </th>
				<td>
					<input type="text" name="lastName" size="15"
						   value="<c:out value='${user.lastName}' />"
					/>
				</td>
			</tr>
			<tr>
				<th>Description: </th>
				<td>
					<input type="text" name="description" size="15"
						   value="<c:out value='${user.description}' />"
					/>
				</td>
			</tr>
			<tr>
				<th>Favorite Color: </th>
				<td>
					<input type="text" name="favoriteColor" size="15"
						   value="<c:out value='${user.favoriteColor}' />"
					/>
				</td>
			</tr>
			<tr>
				<th>Profile Picture: </th>
				<td>
					<input type="text" name="file" size="15"
						   value="<c:out value='${user.file}' />"
					/>
				</td>
			</tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>
