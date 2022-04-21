<?php
echo '<p> Please Wait.... </p>';
$con = mysqli_connect('localhost','root');

if($con){
	echo '<b>***Order Confirmed***</b>';
}else{
	echo "No connection";
}

mysqli_select_db($con,'retrocafe');

$name =$_POST['name'];
$email =$_POST['email'];
$zipcode =$_POST['zipcode'];
$city =$_POST['city'];
$dob =$_POST['dob'];
switch($_POST['gender']) {
        case "F":
            $gender = "F";
            break;
        default:
            $gender = "M";
    }
switch($_POST['pay']) {
        case "D":
            $card = "Debit";
            break;
        default:
            $card = "Credit";
    }
$cardno =$_POST['cardno'];
$cardcvv =$_POST['cardcvv'];
$expmon =$_POST['expmon'];
$expyr =$_POST['expyr'];
$amount =$_POST['amount'];


$query= " insert into payment (type,name,email,zipcode,city,dob,gender,card,cardno,cardcvv,expmon,expyr,amount) values ('card','$name','$email','$zipcode','$city','$dob','$gender','$card','$cardno','$cardcvv','$expmon','$expyr','$amount') ";
mysqli_query($con,$query);
header('location:http://localhost/web%20design%20(2)/order/confirmation.html');
?> 
