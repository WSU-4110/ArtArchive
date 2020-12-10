<?php
if(!empty($_POST["send"])) {
	$name = $_POST["name"];
	$email = $_POST["Email"];
	$issue = $_POST["issue"];
	$message = $_POST["Message"];

	$toEmail = "shussain1104@gmail.com";
	$mailHeaders = "From: " . $name . "<". $email .">\r\n";
	if(mail($toEmail, $issue, $message, $mailHeaders)) {
	    $messageresult = "Your contact information is received successfully.";
	    $type = "success";
	}
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Art Archive - Contact</title>
<script src="https://kit.fontawesome.com/1369e0e729.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="styles.css">
<script src="scripts.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<header><h1>ART ARCHIVE - Contact</h1></header>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav .nav-fill">
      <li class="nav-item">
        <a class="nav-link" href="sales.html">Art Sales <i class="fas fa-comments-dollar"></i></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="index.html">Home <i class="fas fa-archway"></i></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="userDirectory.html">Tutoring <i class="fas fa-chalkboard-teacher"></i></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="profilePage.html">Profile <i class="far fa-address-book"></i></a>
      </li>
	  <li class="nav-item">
        <a class="nav-link" href="#">Register <i class="fas fa-address-book"></i></a>
      </li>
	  <li class="nav-item  active">
        <a class="nav-link" href="contact.html">Contact Us <i class="fas fa-address-book"></i></a>
      </li>
	  <li class="nav-item">
        <a class="nav-link" href="directories.html">Directories <i class="fas fa-book"></i></a>
      </li>
    </ul>
  </div>
</nav>
    <div class="content">
        <h2>Contact Us</h2>
        <p>If you need to get in contact with us, fill out the form below to send a message</p>
        <form method = "post" action = "contact.php">
            <label for="fname">Name</label>
                 <input type="text" id="name" name="name" placeholder="Your name..">
            <label for="email">*Email:</label>
                <input type = "email" name = "Email" id = "email" required = "required">
            <label for="issue">List of Issues Possible: </label>
                <select id="issue" name="issue" placeholder = "Pick from the list of issues..">
                    <option value="Page Not Loading">Page isn't loading</option>
                    <option value="Unable to Post">Unable to Post Artwork</option>
                    <option value="other">Other</option><br>
                    </select>
            <p> If other is selected, explain in the message field below.</p>
            <label for = "message">Message:</label>
                 <textarea name = "Message" rows = "5" cols = "15"></textarea>
                    <button type="submit" value = "Send Message Now" id="mySubmit" required = "required" a href = "mailto:s.hussain1104@gmail.com">
                      Send Message Now</button>
					</form>
    </div>
</body>
<footer class="container-fluid text-center">
    <p><small>Copyright &copy Art Archive 2020</small></p>
  </footer>
</html>
