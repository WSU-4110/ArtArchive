<?php
/* Attempt MySQL server connection. Assuming you are running MySQL
server with default setting (user 'root' with no password) */
$link = mysqli_connect("localhost", "root", "", "artarchive");
 
// Check connection
if($link === false){
    die("ERROR: Could not connect. " . mysqli_connect_error());
}
 
// Escape user inputs for security
$firstname = mysqli_real_escape_string($link, $_REQUEST['firstname']);
$lastname = mysqli_real_escape_string($link, $_REQUEST['lastname']);
$description = mysqli_real_escape_string($link, $_REQUEST['description']);
 
// Attempt insert query execution
$sql = "INSERT INTO profileinfo (firstname, lastname, description) VALUES ('$firstname', '$lastname', '$description')";
if(mysqli_query($link, $sql)){
    echo "Records added successfully.";
} else{
    echo "ERROR: Could not able to execute $sql. " . mysqli_error($link);
}
 
// Close connection
mysqli_close($link);
?>