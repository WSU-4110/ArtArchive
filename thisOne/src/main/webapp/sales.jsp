<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<title>AA - Sales</title>
<%@ include file="WEB-INF/head.html" %>
<header>
    <h1>ART ARCHIVE - Sales</h1>
</header>

<body>
    <%@ include file="WEB-INF/navbar.html" %>
    <div class="content">
        <div id="myData"></div>
        <div class="container">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">Post
            </button>
            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                aria-hidden="true">
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
                                    <input type="text" name="name" class="form-control" size="45"
                                        aria-describedby="emailHelp" placeholder="Enter your title - i.e. 'Rose Petals'"
                                        value="<c:out value='${salePost.name}' />" />
                                    <small id="titleHelp" class="form-text text-muted">Give a descriptive, appropriate
                                        title to your work</small>
                                </div>
                                <div class="form-group">
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">$</span>
                                        </div>
                                        <input type="text" class="form-control" name="description" size="45"
                                            aria-label="Amount (to the nearest dollar)"
                                            value="<c:out value='${salePost.price}' />" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>Piece URL</label>
                                    <input type="text" name="file" class="form-control" size="45"
                                        aria-describedby="emailHelp" placeholder="Enter your title - i.e. 'Rose Petals'"
                                        value="<c:out value='${salePost.file}' />" />
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
            <!-- review -->
            <div class="modal fade" id="reviewModal" tabindex="-1" role="dialog" aria-labelledby="reviewModalLabel"
                aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">New Review</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="postReview" method="post">
                                <div class="form-group">
                                    <label>Review</label>
                                    <input type="text" name="review" class="form-control" size="45"
                                        aria-describedby="emailHelp" placeholder="Enter your review'"
                                        value="<c:out value='${salePost.name}' />" />
                                    <small id="titleHelp" class="form-text text-muted">Give a short review of the
                                        product</small>
                                </div>
                                <div class="form-group">
                                    <label for="exampleFormControlSelect2">Give Stars</label>
                                    <select class="form-control" name="stars" id="exampleFormControlSelect2">
                                        <option>0</option>
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                    </select>
                                </div>
                                <input style="display:none;" type="text" name="user" class="form-control" size="45"
                                    aria-describedby="emailHelp" placeholder="Enter your title - i.e. 'Rose Petals'"
                                    value="<c:out value='${user}' />" />
                                <input style="display:none;" type="text" name="saleId" class="sales form-control"
                                    size="45" aria-describedby="emailHelp"
                                    placeholder="Enter your title - i.e. 'Rose Petals'" />
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- review end -->
            <div class="row">
                <c:forEach var="salePost" items="${listSalePost}" varStatus="loop">
                    <div class="col-lg-2 col-md-3 col-xs-4 ">
                        <div class="box">
                            <iframe src="<c:out value=" ${salePost.file}" />"></iframe>
                            <div>
                                <div class="shadow-none p-3 bg-light">
                                    <c:out value="${salePost.name}" />
                                </div>
                            </div>
                            <div>
                                <div class="shadow-none p-3 bg-light">
                                    <c:out value="${salePost.description}" />
                                </div>
                            </div>
                            <div style="display: flex; justify-content: center;" class="mb-3">
                                <c:choose>
                                    <c:when test="${isReviewed[loop.index]}">
                                    </c:when>
                                    <c:otherwise>
                                        <button type="button" class="btn btn-primary" onclick='handleClick(" <c:out
                                            value=' ${salePost.id}' />")' data-toggle="modal"
                                        data-target="#reviewModal">Write review
                                        </button>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <script type="text/javascript">
            function handleClick(salesId) {
                document.getElementsByClassName('sales')[0].value = salesId

            }
        </script>
    </div>
</body>

</html>