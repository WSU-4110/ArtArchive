<?php
$host="localhost";
$port=3306;
$socket="";
$user="root";
$password="DetroitandNewYork#1104";
$dbname="artarchive";

$con = new mysqli($host, $user, $password, $dbname, $port, $socket) or die ('Could not connect to the database server' . mysqli_connect_error());
$get_topics = "SELECT topic_id, topic_title, FORMAT(topic_create_time, '%b %e %Y at %r') AS fmt_topic_create_time,
 topic_author from questionboard order by topic_create_time desc";
 $get_topics_res = mysqli_query($con,$get_topics);
 if ($con->query($get_topics) === TRUE) 
 {
      if (mysql_num_rows($get_topics_res) < 1) {
        //there are no topics, so say so
         $display_block = "<P><em>No topics exist.</em></p>";
       } 
       else
        {
         //create the display string
         $display_block = "
         <table cellpadding=3 cellspacing=1 border=1>
               <tr>
             <th>TOPIC TITLE</th>
               <th># of POSTS</th>
             </tr>";
     while ($topic_info = mysql_fetch_array($get_topics_res))
      {
       $topic_id = $topic_info['topic_id'];
        $topic_title = stripslashes($topic_info['topic_title']);
        $topic_create_time = $topic_info['fmt_topic_create_time'];
        $topic_owner = stripslashes($topic_info['topic_author']);

        //get number of posts
         $get_num_posts = "SELECT count(topic_id) from questionboard  where topic_id = $topic_id";
         $get_num_posts_res = mysql_query($get_num_posts,$con)or die(mysql_error());
         $num_posts = mysql_result($get_num_posts_res,0,'count(topic_id)');
         //add to display
         $display_block .= "
         <tr>
         <td><a href=\"questionboard.php?topic_id=$topic_id\">
         <strong>$topic_title</strong></a><br>
        Created on $topic_create_time by $topic_owner</td>
         <td align=center>$num_posts</td>
         </tr>";
          }
 
         //close up the table
         $display_block .= "</table>";
    }
    $con->close();
}
else
{
   if($con->query($get_topics)===FALSE)
   {
        echo "Error: " . $get_topics . "<br>" . $con->error;
   }
   $con->close();
}
  ?>
<html lang="en">
<head>
    <h1>Topics in My Forum</h1>
</head>
<body>
      <?php print $display_block; ?>
   <P>Would you like to <a href="questionboard.html">add a topic</a>?</p>
</body>
</main>
</html>