<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<title>AA - Directory</title>
<%@ include file="WEB-INF/head.html" %>
<header><h1>ART ARCHIVE - Directory</h1></header>
<body>
<%@ include file="WEB-INF/navbar.html" %>
<div class="content">
    <div class="container">
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">Post
        </button>
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">New Post</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="postDirectory" method="post">
                            <div class="form-group">
                                <label>Title</label>
                                <input type="text" name="title" class="form-control"  size="45" aria-describedby="emailHelp" placeholder="Enter your title - i.e. 'Rose Petals'" value="<c:out value='${directory.title}' />"/>
                                <small id="titleHelp" class="form-text text-muted">Give a descriptive, appropriate title to your work</small>
                            </div>
                            <div class="form-group">
                                <label>Description</label>
                                <input type="text" name="description" class="form-control"  size="45" aria-describedby="emailHelp" placeholder="Enter your title - i.e. 'Rose Petals'" value="<c:out value='${directory.description}' />"/>
                                <small class="form-text text-muted"></small>
                            </div>
                            <div class="form-group">
                                <label>Link</label>
                                <input type="text" name="link" class="form-control"  size="45" aria-describedby="emailHelp" placeholder="Enter your directory url..." value="<c:out value='${directory.link}' />"/>
                                <small class="form-text text-muted">Please input your share link here</small>
                            </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg">
                <div class="articles card">
                    <div class="card-header d-flex align-items-center">
                        <h2 class="h3">Latest Articles</h2>
                    </div>
                    <div class="card-body no-padding">
                        <c:forEach var="directory" items="${listDirectory}">
                            <div class="item d-flex align-items-center">
                                <div class="text"><a href="<c:out value="${directory.link}" />">
                                    <h3 class="h5"><c:out value="${directory.title}" /></h3></a><small>Posted by <c:out value="${directory.user}" />   </small></div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>