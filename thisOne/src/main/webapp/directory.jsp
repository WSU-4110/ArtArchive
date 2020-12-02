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
                        <form  method = "post" action = "https://webdevbasics.net/scripts/javajam8.php">
                            <div class="form-group">
                                <label>Title</label>
                                <input type="text" class="form-control" id="title" name="titleArtwork" aria-describedby="emailHelp" placeholder="Enter your title - i.e. 'Rose Petals'">
                                <small id="titleHelp" class="form-text text-muted">Give a descriptive, appropriate title to your work</small>
                            </div>
                            <div class="form-group">
                                <label>File Upload</label>
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
            <div class="col-lg">
                <div class="articles card">
                    <div class="card-close">
                        <div class="dropdown">
                            <button type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-ellipsis-v"></i></button>
                            <div aria-labelledby="closeCard4" class="dropdown-menu dropdown-menu-right has-shadow"><a href="#" class="dropdown-item remove"> <i class="fa fa-times"></i>Close</a><a href="#" class="dropdown-item edit"> <i class="fa fa-gear"></i>Edit</a></div>
                        </div>
                    </div>
                    <div class="card-header d-flex align-items-center">
                        <h2 class="h3">Latest</h2>
                    </div>
                    <div class="card-body no-padding">
                        <div class="item d-flex align-items-center">
                            <div class="image"><img src="images/av1.jpg" alt="..." class="img-rounded"></div>
                            <div class="text"><a href="docs/clay.docx" download>
                                <h3 class="h5">Claymation Tips and Tricks</h3></a><small>Posted on 5th June 2017 by Aria Smith.   </small></div>
                        </div>
                        <div class="item d-flex align-items-center">
                            <div class="image"><img src="images/av2.jpg" alt="..." class="img-rounded"></div>
                            <div class="text"><a href="docs/sculpt.docx" download>
                                <h3 class="h5">Sculpting Fundamentals</h3></a><small>Posted on 5th June 2017 by Frank Williams.   </small></div>
                        </div>
                        <div class="item d-flex align-items-center">
                            <div class="image"><img src="images/av3.jpg" alt="..." class="img-rounded"></div>
                            <div class="text"><a href="docs/howto1.docx" download>
                                <h3 class="h5">Tradition vs Modern Oil Pastel</h3></a><small>Posted on 5th June 2017 by Ashley Wood.   </small></div>
                        </div>
                        <div class="item d-flex align-items-center">
                            <div class="image"><img src="images/av4.jpg" alt="..." class="img-rounded"></div>
                            <div class="text"><a href="docs/howto2.docx" download>
                                <h3 class="h5">How to reuse brushes</h3></a><small>Posted on 5th June 2017 by Jason Doe.   </small></div>
                        </div>
                        <div class="item d-flex align-items-center">
                            <div class="image"><img src="images/av5.jpg" alt="..." class="img-rounded"></div>
                            <div class="text"><a href="docs/ash.docx" download>
                                <h3 class="h5">How to make an ashtray from bread</h3></a><small>Posted on 5th June 2017 by Sam Martinez.   </small></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="content">
    <div class="container">
        <div class="row">
            <div class="col-lg">
                <div class="articles card">
                    <div class="card-close">
                        <div class="dropdown">
                            <button type="button" id="closeCard4" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-ellipsis-v"></i></button>
                            <div aria-labelledby="closeCard4" class="dropdown-menu dropdown-menu-right has-shadow"><a href="#" class="dropdown-item remove"> <i class="fa fa-times"></i>Close</a><a href="#" class="dropdown-item edit"> <i class="fa fa-gear"></i>Edit</a></div>
                        </div>
                    </div>
                    <div class="card-header d-flex align-items-center">
                        <h2 class="h3">Popular</h2>
                    </div>
                    <div class="card-body no-padding">
                        <div class="item d-flex align-items-center">
                            <div class="image"><img src="images/av1.jpg" alt="..." class="img-rounded"></div>
                            <div class="text"><a href="#">
                                <h3 class="h5">Claymation Tips and Tricks</h3></a><small>Posted on 5th June 2017 by Aria Smith.   </small></div>
                        </div>
                        <div class="item d-flex align-items-center">
                            <div class="image"><img src="images/av2.jpg" alt="..." class="img-rounded"></div>
                            <div class="text"><a href="#">
                                <h3 class="h5">Sculpting Fundamentals</h3></a><small>Posted on 5th June 2017 by Frank Williams.   </small></div>
                        </div>
                        <div class="item d-flex align-items-center">
                            <div class="image"><img src="images/av3.jpg" alt="..." class="img-rounded"></div>
                            <div class="text"><a href="#">
                                <h3 class="h5">Tradition vs Modern Oil Pastel</h3></a><small>Posted on 5th June 2017 by Ashley Wood.   </small></div>
                        </div>
                        <div class="item d-flex align-items-center">
                            <div class="image"><img src="images/av4.jpg" alt="..." class="img-rounded"></div>
                            <div class="text"><a href="#">
                                <h3 class="h5">How to reuse brushes</h3></a><small>Posted on 5th June 2017 by Jason Doe.   </small></div>
                        </div>
                        <div class="item d-flex align-items-center">
                            <div class="image"><img src="images/av5.jpg" alt="..." class="img-rounded"></div>
                            <div class="text"><a href="#">
                                <h3 class="h5">How to make an ashtray from bread</h3></a><small>Posted on 5th June 2017 by Sam Martinez.   </small></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
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
                <c:forEach var="directory" items="${listDirectories}">
                    <tr>
                        <td><c:out value="${directory.id}" /></td>
                        <td><c:out value="${directory.name}" /></td>
                        <td><c:out value="${directory.description}" /></td>
                        <td><c:out value="${directory.user}" /></td>
                        <td>
                            <a href="edit?id=<c:out value='${directory.id}' />">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="delete?id=<c:out value='${directory.id}' />">Buy</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</html>