<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<title>AA - Sales</title>
<%@ include file="WEB-INF/head.html" %>
<header><h1>ART ARCHIVE - Sales</h1></header>
<body>
<%@ include file="WEB-INF/navbar.html" %>
<div class="content">
    <div id="myData"></div>
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
                        <form action="postSale" method="post">
                            <div class="form-group">
                                <label>Title</label>
                                <input type="text" name="name" class="form-control"  size="45" aria-describedby="emailHelp" placeholder="Enter your title - i.e. 'Rose Petals'" value="<c:out value='${salePost.name}' />"/>
                                <small id="titleHelp" class="form-text text-muted">Give a descriptive, appropriate title to your work</small>
                            </div>
                            <div class="form-group">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">$</span>
                                    </div>
                                    <input type="text" class="form-control" name="description" size="45" aria-label="Amount (to the nearest dollar)" value="<c:out value='${salePost.price}' />"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Piece URL</label>
                                <input type="text" name="file" class="form-control"  size="45" aria-describedby="emailHelp" placeholder="Enter your title - i.e. 'Rose Petals'" value="<c:out value='${salePost.file}' />"/>
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
            <c:forEach var="salePost" items="${listSalePost}">
                <div class="col-lg-2 col-md-3 col-xs-4 ">
                    <div class="box">
                        <iframe src="<c:out value="${salePost.file}" />"></iframe>
                        <div>
                            <div class="shadow-none p-3 bg-light"><c:out value="${salePost.name}" /></div>
                        </div>
                        <div>
                            <div class="shadow-none p-3 mb-5 bg-light"><c:out value="${salePost.description}" /></div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>

