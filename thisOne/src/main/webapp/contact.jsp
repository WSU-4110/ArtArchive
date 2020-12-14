<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="WEB-INF/styles.css" rel="stylesheet" type="text/css">
<header><h1>ART ARCHIVE - Contact</h1></header>
<%@ include file="WEB-INF/head.html" %>
<body>
<%@ include file="WEB-INF/navbar.html" %>
    <div class="content">
        <h2>Contact Us</h2>
        <p>If you need to get in contact with us, fill out the form below to send a message</p>
        <form action="mailto:shussain1104@gmail.com" method="GET">
            <label for="fname">First Name</label>
                 <input type="text" id="fname" name="firstname" placeholder="Your name..">
            <label for="lname">Last Name</label>
                <input type="text" id="lname" name="lastname" placeholder="Your last name..">
            <label for="email">*Email:</label>
                <input type = "email" name = "Email" id = "email" required = "required">
            <label for="issue">List of Issues Possible: </label>
                <select id="issue" name="issue" placeholder = "Pick from the list of issues..">
                    <option value="Page Not Loading">Page isn't loading</option>
                    <option value="Unable to Post">Unable to Post Artwork</option>
                    <option value="other">Other</option><br>
                    </select>
            <p> If other is selected, explain in the message field below.</p>
            <label>Message:</label>
                 <textarea name = "Message" rows = "5" cols = "15"></textarea>
                    <button type="submit"  value = "Send Message Now" id="mySubmit" required = "required">
                    Send Message Now</button>
					</form>
    </div>
</body>
<footer class="container-fluid text-center">
    <p><small>Copyright &copy Art Archive 2020</small></p>
  </footer>
</html>
