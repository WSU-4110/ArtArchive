<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<title>Profile</title>
<%@ include file="head.html" %>
<body>
<%@ include file="navbar.html" %>
<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <img src="l60Hf.png" class="img-circle" alt="Profile Picture Test" width="100" height="100">
            <h2>My Name</h2>
            <p><a href="profilePageEdit.html">Edit</a></p>
            <p>User description.</p>
        </div>
        <div class="col-sm-10 text-left">
            <div class="media">
                <div class="media-left">
                    <img src="l60Hf.png" class="media-object" style="width:60px">
                </div>
                <div class="media-body">
                    <h4 class="media-heading">My Name</h4>
                    <p>Testing a post.</p>
                    <img src="photographyTest.jpg" class="img-rounded" alt="Photography Test" style="width:500px;height:500px;">
                </div>
            </div>
            <hr>
        </div>
    </div>
</div>
</div>
</body>
</html>
