
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <!-- Basic -->

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Site Metas -->
        <title>Bookstore | <c:out value="${product.name}"/></title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Site Icons -->
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="images/apple-touch-icon.png">

        <!-- Bootstrap CSS -->
        <!--    <link rel="stylesheet" href="css/bootstrap.min.css">-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" 
              integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <!-- Site CSS -->
        <link rel="stylesheet" href="css/style.css">
        <!-- Responsive CSS -->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/custom.css">

        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>
        <!-- Start Main Top -->
        <header class="main-header">
            <!-- Start Navigation -->
            <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav">
                <div class="container">
                    <!-- Start Header Navigation -->
                    <div class="navbar-header">
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-menu" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
                            <i class="fa fa-bars"></i>
                        </button>
                        <a class="navbar-brand" href="home"><img src="images/logo.png" class="logo" alt=""></a>
                    </div>
                    <!-- End Header Navigation -->

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="navbar-menu">
                        <ul class="nav navbar-nav ml-auto" data-in="fadeInDown" data-out="fadeOutUp">
                            <li class="nav-item"><a class="nav-link" href="home">Home</a></li>
                                <c:choose>
                                    <c:when test="${sessionScope.user == null || sessionScope.pass == null}">
                                        ${'<li class="nav-item"><a class="nav-link" href="signin">Sign In <i class="fas fa-sign-in-alt"></i></a></li>'}
                                    </c:when>
                                    <c:otherwise>
                                        ${'<li class="nav-item"><a class="nav-link" href="account.jsp">Account <i class="fas fa-user-circle"></i></a></li>'}
                                    </c:otherwise>
                                </c:choose>
                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->

                    <!-- Start Atribute Navigation -->
                    <div class="attr-nav">
                        <ul>

                            <li class="side-menu"><a href="cart">
                                    <i class="fa fa-shopping-bag"></i>
                                    <span class="badge"></span>
                                    <p>My Cart</p>
                                </a></li>
                        </ul>
                    </div>
                    <!-- End Atribute Navigation -->
                </div>
                <!-- Start Side Menu -->

                <!-- End Side Menu -->
            </nav>
            <!-- End Navigation -->
        </header>
        <!-- End Main Top -->

        <!-- Start Top Search -->
        <div class="top-search">
            <div class="container">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-search"></i></span>
                    <input type="text" class="form-control" placeholder="Search">
                    <span class="input-group-addon close-search"><i class="fa fa-times"></i></span>
                </div>
            </div>
        </div>
        <!-- End Top Search -->

        <!-- Start All Title Box -->
        <div class="all-title-box">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <h2><c:out value="Book : ${product.name}"/></h2>

                    </div>
                </div>
            </div>
        </div>
        <!-- End All Title Box -->

        <!-- Start Shop Detail  -->
        <div class="shop-detail-box-main">
            <div class="container">
                <div class="row">
                    <div class="col-xl-5 col-lg-5 col-md-6">
                        <div id="carousel-example-1" class="single-product-slider carousel slide" data-ride="carousel">
                            <div class="carousel-inner" role="listbox">
                                <div class="carousel-item active"> <img class="d-block w-100" src="products/<c:out value="${product.image}"/>" alt="First slide"> </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-7 col-lg-7 col-md-6">
                        <div class="single-product-details">
                            <h2><c:out value="${product.name}"/></h2>
                            <h5> $<c:out value="${product.price}"/></h5>

                            <h4>Description:</h4>
                            <p><c:out value="${product.description}"/></p>
                            <div class="price-box-bar">
                                <div class="cart-and-bay-btn">
                                    <c:choose>
                                        <c:when test="${sessionScope.user == null || sessionScope.pass == null}">
                                            <a class="btn hvr-hover" data-fancybox-close="" href="signin">Add to cart</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a class="btn hvr-hover" data-fancybox-close="" href="home?catid=${catid}&pid=${product.pid}&amount=1" onclick="showAlert()" method="post">Add to cart</a>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <!-- End Cart -->




        
               <!-- Start Footer  -->
        <footer>
            <div class="footer-main">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4 col-md-12 col-sm-12">
                            <div class="footer-top-box">
                                <h3>Office Address</h3>
                                <ul class="list-time">
                                    <li>Trường Đại học FPT Hà Nội</li><li>Km29 - Đại lộ Thăng Long</li> <li>Khu CNC Hòa Lạc</li> <li>xã Thạch Hòa, huyện Thạch Thất</li> <li>Thành phố Hà Nội</li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-12 col-sm-12">
                            <div class="footer-top-box">
                                <h3>Social Media</h3>
                                <p></p>
                                <ul>
                                    <li><a href="#"><i class="fab fa-facebook" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="fab fa-twitter" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="fab fa-linkedin" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="fab fa-google-plus" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="fa fa-rss" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="fab fa-pinterest-p" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="fab fa-whatsapp" aria-hidden="true"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <hr>
                </div>
            </div>
        </footer>
        <!-- End Footer  -->
        <!-- End Footer  -->

        <!-- Start copyright  -->
        <div class="footer-copyright">
            <p class="footer-company">2023 &copy; by <a href="#" target="_blank">Nguyen Hong Son</a> - PRJ301
        </div>
        <!-- End copyright  -->

        <a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

        <a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

        <!-- ALL JS FILES -->
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <!-- ALL PLUGINS -->
        <script src="js/jquery.superslides.min.js"></script>
        <script src="js/bootstrap-select.js"></script>
        <script src="js/inewsticker.js"></script>
        <script src="js/bootsnav.js."></script>
        <script src="js/images-loded.min.js"></script>
        <script src="js/isotope.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/baguetteBox.min.js"></script>
        <script src="js/form-validator.min.js"></script>
        <script src="js/contact-form-script.js"></script>
        <script src="js/custom.js"></script>
        <script src="https://kit.fontawesome.com/228aa84c51.js" crossorigin="anonymous"></script>
    </body>

</html>
