<?php

$con = mysqli_connect('localhost','root');

if($con){
	echo "Connection successful";
}else{
	echo "no connection";
}

mysqli_select_db($con, 'retrocafe');

$name = $_POST['name'];
$email = $_POST['email'];
$review = $_POST['review'];

$query = "insert into review (name, email, review)
values('$name','$email','$review')";

mysqli_query($con,$query);

header('location:http://localhost/web%20design%20(4)/aboutreview/index.php');

?>