<!DOCTYPE html>
<html lang="en">
<head>
    <title>Art Archive - Contact</title>
    <script src="https://kit.fontawesome.com/1369e0e729.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="WEB-INF/styles.css">
    <script src="scripts.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<header><h1>Art Archive- Q&A Board</h1></header>
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
                <a class="nav-link disabled" href="#">Profile <i class="far fa-address-book"></i></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Register <i class="fas fa-address-book"></i></a>
            </li>
            <li class="nav-item  active">
                <a class="nav-link" href="contact.html">Contact Us <i class="fas fa-address-book"></i></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Questionboard.html">Q&A Board <i class="fas fa-archway"></i></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="directories.html">Directories <i class="fas fa-book"></i></a>
            </li>
        </ul>
    </div>
</nav>
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
                    <form method = "post" action = "questionboard.php">
                        <div class="form-group">
                            <label> Name/Username: </label><br>
                            <input type="text" name="topic_author" size=40 maxlength=150>
                            <label>Topic:</label><br>
                            <input type="text" name="topic_title" size=40 maxlength=150>
                            <left><label for="subject">Question:</label></left>
                            <textarea id="subject" name="topicquestion" placeholder="What is Your Question?" style="height:200px"></textarea>
                            <button type="submit" value = "Submit"  required = "required">Submit</button>
                    </form>
    </body>
</main>
</html>