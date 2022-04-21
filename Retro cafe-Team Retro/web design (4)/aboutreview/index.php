<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <!-- css link -->
    <link rel="stylesheet" type="text/css" href="css/style.css">

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&family=Bebas+Neue&family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">

    <!-- owl carrasol -->
    <link rel="stylesheet" type="text/css" href="css/owl.carousel.min.css">
    <link rel="stylesheet" type="text/css" href="css/owl.theme.default.min.css">

    <!-- font awesome -->
    <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- wow css -->
    <link rel="stylesheet" href="css/animate.css">

    <title>🔎About Us</title>
  </head>
  <body>


 <!-- header section -->
 <header>
  <div class="container">
    

        <!-- menu -->
        <div class="row">
          <div class="col-md-12">
          <nav class="navbar navbar-expand-lg navbar-light ">
     <div > <a class="navbar-brand" href="index.html"> </a> </div>
         
       <div>
        <div class="delivery-info">
          <img src="img/logo2.png">
          <span>CAFE RETRO +880 1740 745 000</span>
        </div>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link "  href="http://localhost/web%20design/index.php">Home</a>
        </li>
        <!--<li class="nav-item">
          <a class="nav-link" href="http://localhost/web%20design%20(2)/order/index.html">ORDER</a>
        </li> -->
        <li class="nav-item">
          <a class="nav-link" href="http://localhost/web%20design%20(3)/menu/index.html">Unique Menu</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active new ms-2 " aria-current="page" href="#">ABOUT US</a>
        </li>

      </ul>

      </div>
      </div>

     </nav>
          </div>
        </div>
        <!-- banner -->
        <div class="row">
          <div class="col-md-12">
            <div class="banner-text">
               <p class="wow headShake">Welcome To Cafe Retro</p>
               <h1 class=" wow bounceInDown " >Cafe Retro</h1>
               
            </div>
            
          </div>
        </div>
        
  </div>
      
 </header>
    <!-- header section end -->


    <!-- about section starts  -->

<section class="about" id="about">

    <h3 class="sub-heading"> about us </h3>
    <h1 class="heading"> why choose us? </h1>

    <div class="row">

        <div class="image">
            <img src="img/about-img.png" alt="">
        </div>

        <div class="content">
            <h3>best food in the country</h3>
            <p>Quality Cuisine:
When you order food you want someone you can rely on to provide good quality and professional cuisine. Cafe Retro can assure you of this.<p>

<p>Fresh Food:
All our food is freshly prepared on a daily basis ensuring that you receive only the finest cuisine ,delicious to taste. Our food not only tastes good it looks wonderful as well.</p>
            <p>Friendly Staff & Quick Delivery: 
Our staff understand that this is your day and that we need to be polite and courteous. We strive for excellence both in the quality of our food and in our interaction with you.Also deliver the food very quickly..</p>
            <div class="icons-container">
                <div class="icons">
                    <i class="fa fa-shipping-fast"></i>
                    <span>fast delivery</span>
                </div>
                <div class="icons">
                    <i class="fa fa-dollar-sign"></i>
                    <span>easy payments</span>
                </div>
                <div class="icons">
                    <i class="fa fa-headset"></i>
                    <span>24/7 service</span>
                </div>
            </div>
            <a href="http://localhost/web%20design%20(6)/index.html" class="btn">learn more</a>
        </div>

    </div>

</section>

<!-- about section ends -->




<!-- review section starts  -->

<section class="review" id="review">

    <h3 class="sub-heading"> customer's review </h3>
    <h1 class="heading"> what they say </h1>

    <div class="swiper-container review-slider">

        <div class="swiper-wrapper">

            <div class="swiper-slide slide">
                <i class="fa fa-quote-right"></i>
                <div class="user">
                    <img src="img/pic-90.png" alt="">
                    <div class="user-info">
                        <h3>
                            <?php 
                                $con = mysqli_connect('localhost','root');
                                if($con){
                                    mysqli_select_db($con, 'retrocafe');

                                    $query= "SELECT name FROM review ORDER BY ID DESC";

                                    $result=mysqli_query($con,$query);

                                    $row = mysqli_fetch_array($result);
                                    echo $row['name'];
                                }else{
                                    echo "no connection";
                                }

                            ?> 
                        </h3>
                           
                    </div>
                </div>
                <p><?php 
                                $con = mysqli_connect('localhost','root');
                                if($con){
                                    mysqli_select_db($con, 'retrocafe');

                                    $query= "SELECT review FROM review ORDER BY ID DESC";

                                    $result=mysqli_query($con,$query);

                                    $row = mysqli_fetch_array($result);
                
                                    echo $row['review'];
                                }else{
                                    echo "no connection";
                                }

                            ?></p>
            </div>

            <div class="swiper-slide slide">
                <i class="fa fa-quote-right"></i>
                <div class="user">
                    <img src="img/pic-90.png" alt="">
                    <div class="user-info">
                        <h3><?php 
                                $con = mysqli_connect('localhost','root');
                                if($con){
                                    mysqli_select_db($con, 'retrocafe');

                                    $query= "SELECT name FROM review ORDER BY ID DESC";

                                    $result=mysqli_query($con,$query);

                                    $row = mysqli_fetch_array($result);
                                    $row = mysqli_fetch_array($result);
                                    echo $row['name'];
                                }else{
                                    echo "no connection";
                                }
                            ?>
                        </h3>
                    </div>
                </div>
                <p><?php 
                                $con = mysqli_connect('localhost','root');
                                if($con){
                                    mysqli_select_db($con, 'retrocafe');

                                    $query= "SELECT review FROM review ORDER BY ID DESC";

                                    $result=mysqli_query($con,$query);

                                    $row = mysqli_fetch_array($result);
                                    $row = mysqli_fetch_array($result);
                
                                    echo $row['review'];
                                }else{
                                    echo "no connection";
                                }

                            ?></p>
            </div>

            <div class="swiper-slide slide">
                <i class="fa fa-quote-right"></i>
                <div class="user">
                    <img src="img/pic-90.png" alt="">
                    <div class="user-info">
                        <h3><?php 
                                $con = mysqli_connect('localhost','root');
                                if($con){
                                    mysqli_select_db($con, 'retrocafe');

                                    $query= "SELECT name FROM review ORDER BY ID DESC";

                                    $result=mysqli_query($con,$query);

                                    $row = mysqli_fetch_array($result);
                                    $row = mysqli_fetch_array($result);
                                    $row = mysqli_fetch_array($result);
                                    echo $row['name'];
                                }else{
                                    echo "no connection";
                                }

                            ?> 
                        </h3>
                        
                    </div>
                </div>
                <p><?php 
                                $con = mysqli_connect('localhost','root');
                                if($con){
                                    mysqli_select_db($con, 'retrocafe');

                                    $query= "SELECT review FROM review ORDER BY ID DESC";

                                    $result=mysqli_query($con,$query);

                                    $row = mysqli_fetch_array($result);
                                    $row = mysqli_fetch_array($result);
                                    $row = mysqli_fetch_array($result);
                
                                    echo $row['review'];
                                }else{
                                    echo "no connection";
                                }

                            ?></p>
            </div>

            <div class="swiper-slide slide">
                <i class="fa fa-quote-right"></i>
                <div class="user">
                    <img src="img/pic-90.png" alt="">
                    <div class="user-info">
                        <h3><?php 
                                $con = mysqli_connect('localhost','root');
                                if($con){
                                    mysqli_select_db($con, 'retrocafe');

                                    $query= "SELECT name FROM review ORDER BY ID DESC";

                                    $result=mysqli_query($con,$query);

                                    $row = mysqli_fetch_array($result);
                                    $row = mysqli_fetch_array($result);
                                    $row = mysqli_fetch_array($result);
                                    $row = mysqli_fetch_array($result);
                                    echo $row['name'];
                                }else{
                                    echo "no connection";
                                }

                            ?></h3>
                    </div>
                </div>
                <p><?php 
                                $con = mysqli_connect('localhost','root');
                                if($con){
                                    mysqli_select_db($con, 'retrocafe');

                                    $query= "SELECT review FROM review ORDER BY ID DESC";

                                    $result=mysqli_query($con,$query);

                                    $row = mysqli_fetch_array($result);
                                    $row = mysqli_fetch_array($result);
                                    $row = mysqli_fetch_array($result);
                                    $row = mysqli_fetch_array($result);
                
                                    echo $row['review'];
                                }else{
                                    echo "no connection";
                                }

                            ?></p>
            </div>

        </div>

    </div>
    
</section>

<!-- review section ends -->




<!-- form section -->

 <section class="form-section">
   <div class="container">
    <div class="row text-center">
      <h3 class="wow fadeInUp" data-wow-duration="1s"data-wow-delay="0.8s">REVIEW</h3>
      <h1 class="wow fadeInUp" data-wow-duration="1s"data-wow-delay="0.8s">SUBMIT YOUR REVIEW</h1>
      <form action="http://localhost/web%20design%20(4)/aboutreview/php/userinfo.php" method="post">
        <div class="box">
          <input type="text" name="name" placeholder="Name">
          <input type="email" name="email" placeholder="Email">
        </div>
        <div class="box">
          <input type="txt" name="review" placeholder="review">
          <input type="submit" name="" value="submit" class="table" >
        </div>
      </form>
      
    </div>
     
   </div>
 </section>










<!-- footer -->

 <section class="footer">
   <div class="container">
     
       <div class="footer-content" >
        
          <div class="footer-text ">
            <img src="img/logo3.png" class="footer-logo img-fluid">
            <p class="fottertext">Welcome to Cafe Retro.Best Cafe in Bangladesh.</br> Come & Enjoy our delicious dish.</br>Unique and tasty Food items</br> With many facilities.</p>
            <p class="footerend">© Cafe Retro. All rights reserved.</p>
          </div>
          <div class="icon">
            <ul>
        <li><a href="https://www.facebook.com/annesha.tasneem.3"><i class="fa fa-facebook"></i></a></li>
        <li><a href="https://mobile.twitter.com/cupidonduty/status/1458827128246439942"><i class="fa fa-twitter"></i></a></li>
        <li><a href="http://be.net/naimulpeal"><i class="fa fa-behance"></i></a></li>
       <li><a href=""><i class="fa fa-github"></i></a></li>
      
        </ul>
          </div>
        </div>

      
     </div>
   </div>
 </section>





    <!-- Option 2: Separate Popper and Bootstrap JS -->
    
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
    
    <!-- owl java file -->
    <script src="js/jquery.min.js" ></script>
    <script src="js/owl.carousel.js"></script>

    <script type="">
      $('.owl-carousel').owlCarousel({
    loop:true,
    margin:10,
    nav:false,
    autoplay:false,
     autoplayTimeout:1000,
     autoplayHoverPause:true,
    responsive:{
        0:{
            items:1
        },
        600:{
            items:1
        },
        1000:{
            items:1
        }
    }
   })
    </script>


   <!-- wow js -->
    <script src="js/wow.min.js"></script>
              <script>
              new WOW().init();
              </script>
  </body>
</html>



<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

<!-- custom js file link  -->
<script src="js/script.js"></script>
    <audio autoplay loop>
      <source src="music/music.mpeg" type="audio/mpeg" />
    </audio>

</body>
</html>

