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
                                <label>Piece Input</label>
                                <input type="file" class="form-control-file" id="file" name="fileArtwork">
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
            <div class="col-lg-2 col-md-3 col-xs-4 ">
                <div class="box">
                    <img src="https://tinyurl.com/y4b6byep">
                    <div>
                        <div class="shadow-none p-3 bg-light">The Snail</div>
                    </div>
                    <div>
                        <div class="shadow-none p-3 mb-5 bg-light">$14.99</div>
                    </div>
                </div>
            </div>
            <div class="col-lg-2 col-md-3 col-xs-4 ">
                <div class="box">
                    <img src="https://tinyurl.com/y45dq4so">
                    <div>
                        <div class="shadow-none p-3 bg-light">Hallowed Red</div>
                    </div>
                    <div>
                        <div class="shadow-none p-3 mb-5 bg-light">$89.95</div>
                    </div>
                </div>
            </div>
            <div class="col-lg-2 col-md-3 col-xs-4 ">
                <div class="box">
                    <img src="https://tinyurl.com/y3hdsj2m">
                    <div>
                        <div class="shadow-none p-3 bg-light">Self Portrait</div>
                    </div>
                    <div>
                        <div class="shadow-none p-3 mb-5 bg-light">$79.99</div>
                    </div>
                </div>
            </div>
            <div class="col-lg-2 col-md-3 col-xs-4 ">
                <div class="box">
                    <img src="https://tinyurl.com/y5mlca3v">
                    <div>
                        <div class="shadow-none p-3 bg-light">Success</div>
                    </div>
                    <div>
                        <div class="shadow-none p-3 mb-5 bg-light">$99.99</div>
                    </div>
                </div>
            </div>
            <div class="col-lg-2 col-md-3 col-xs-4 ">
                <div class="box">
                    <img src="https://tinyurl.com/y3243mrb">
                    <div>
                        <div class="shadow-none p-3 bg-light">Pattern in Yellow</div>
                    </div>
                    <div>
                        <div class="shadow-none p-3 mb-5 bg-light">$612.05</div>
                    </div>
                </div>
            </div>
            <div class="col-lg-2 col-md-3 col-xs-4 ">
                <div class="box">
                    <img src="https://tinyurl.com/yxekvz4h">
                    <div>
                        <div class="shadow-none p-3 bg-light">Heirs</div>
                    </div>
                    <div>
                        <div class="shadow-none p-3 mb-5 bg-light">$79.99</div>
                    </div>
                </div>
            </div>			<div class="col-lg-2 col-md-3 col-xs-4 ">
            <div class="box">
                <img src="https://tinyurl.com/y6sqrghg">
                <div>
                    <div class="shadow-none p-3 bg-light">The Deeds to be</div>
                </div>
                <div>
                    <div class="shadow-none p-3 mb-5 bg-light">$59.99</div>
                </div>
            </div>
        </div>
            <div class="col-lg-2 col-md-3 col-xs-4 ">
                <div class="box">
                    <img src="https://tinyurl.com/y4jeglzc">
                    <div>
                        <div class="shadow-none p-3 bg-light">Wartime</div>
                    </div>
                    <div>
                        <div class="shadow-none p-3 mb-5 bg-light">$79.99</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-12">
            <table class="table table-image">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Description</th>
                    <th scope="col">User</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="salePost" items="${listSalePost}">
                    <tr>
                        <td><c:out value="${salePost.id}" /></td>
                        <td><c:out value="${salePost.name}" /></td>
                        <td><c:out value="${salePost.description}" /></td>
                        <td><c:out value="${salePost.user}" /></td>
                        <td>
                            <a href="edit?id=<c:out value='${salePost.id}' />">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="delete?id=<c:out value='${salePost.id}' />">Buy</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>

