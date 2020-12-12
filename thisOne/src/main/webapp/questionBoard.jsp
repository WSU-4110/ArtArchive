<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<%@ include file="WEB-INF/head.html" %>
<header><h1>Art Archive- Q&A Board</h1></header>
<body>
<%@ include file="WEB-INF/navbar.html" %>
<main>
    <h2>Questions</h2>
    <body>
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">New Post
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
                    <form method = "post" action = "insertquestion">
                        <div class="form-group">
                            <caption>
                            <label> Name/Username: </label><br>
                            <input type="text" name="topic_author" size=40 maxlength=150>
                            </caption>
                            <label>Topic:</label><br>
                            <input type="text" name="topic_title" size=40 maxlength=150>
                            <left><label for="subject">Question:</label></left>
                            <textarea id="subject" name="topicquestion" placeholder="What is Your Question?" style="height:200px"></textarea>
                            <button type="submit" value = "Submit"  required = "required">Submit</button></div>
                    </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg">
                <div class="articles card">
                    <div class="card-header d-flex align-items-center">
                        <h2 class="h3">Latest Questions</h2>
                    </div>
                    <div class="card-body no-padding">
                        <c:forEach var="questionboard" items="${listquestions}">
                            <div class="item d-flex align-items-center">
                                <div class="text"><c:out value="${questionboard.topicquestion}" />
                                    <h3 class="h5"><c:out value="${questionboard.topic_title}" /></h3><small>
                                    Posted by <c:out value="${questionboard.topic_author}" />   </small></div>
                            </div>
                        </c:forEach>
                    </div>
                 </div>
            </div>
        </div>
    </body>
</main>
</html>