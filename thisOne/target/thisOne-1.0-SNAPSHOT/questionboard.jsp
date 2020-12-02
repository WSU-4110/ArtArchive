<%--
  Created by IntelliJ IDEA.
  User: Hussa
  Date: 11/25/2020
  Time: 9:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Board of Questions</title></head>
<body bgcolor="white">
<jsp:useBean id="questionboard" scope="application">

<form name="questionboard" action="QuestionBoard" method="post">
    <div class="form-group">
        <label> Name/Username: </label><br>
        <input type="text" name="topic_author" size=40 maxlength=150>
        <!--Same as addName()-->
        <label>Topic:</label><br>
        <input type="text" name="topic_title" size=40 maxlength=150>
        <!--Same as addTopic()-->
        <left><label for="subject">Question:</label></left>
        <!--Same as addQuestion()-->
        <textarea id="subject" name="topicquestion" placeholder="What is Your Question?" style="height:200px"></textarea>
        <button type="submit" value = "Submit"  required = "required">Submit</button>
        <!--Submit will register the post and then a separate function will be written for the post to display-->
    </div>
</form>
</jsp:useBean>
</body>
</html>