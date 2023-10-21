<%@page import="dal.AccountDAL"%>
<%@page import="model.Account"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    AccountDAL aDAL = new AccountDAL();
    Account currAcc = aDAL.getAccountByUsername((String)session.getAttribute("user"));
    request.setAttribute("currAcc", currAcc);
%>
<html lang="en">
    <!-- Basic -->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Site Metas -->
        <title>Profile</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Site Icons -->
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="images/apple-touch-icon.png">

        <!-- Bootstrap CSS -->
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
                            <li class="nav-item active"><a class="nav-link" href="account">Account <i class="fas fa-user-circle"></i></a></li>
                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->

                    <!-- Start Atribute Navigation -->
                    <div class="attr-nav">
                        <ul>
                            
                            <li class="side-menu"><a href="cart.jsp">
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
                        <h2><c:out value="Hello ${currAcc.username}"/> </h2>
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active"> Profile </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- End All Title Box -->

        <!-- Start Contact Us  -->
        <div class="contact-box-main">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-sm-12">
                        <div class="">
                            <h1><b>Edit Product</b></h1>
                            <form name="adminEdit" action="adminEdit" method="post">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="name">Id Product: </label>
                                            <input type="text" class="form-control" id="name" name="pid" required data-error="Please enter your name" value="<c:out value="${product.pid}"/>" readonly="">
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="name">Name Product: </label>
                                            <input type="text" class="form-control" id="name" name="name" required data-error="Please enter your name" value="<c:out value="${product.name}"/>" >
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>
                                   <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="name">Description </label>
                                            <input type="text" class="form-control" id="name" name="description" required data-error="Please enter your name" value="<c:out value="${product.description}"/>" >
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="name"> Price</label>
                                            <input type="number" min="1" step="0.2" class="form-control" name="price" required data-error="Please enter your name" value="<c:out value="${product.price}"/>" >
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="name">Quantity </label>
                                            <input type="number" min="1" step="1" class="form-control" name="quantity" required data-error="Please enter your name" value="<c:out value="${product.quantity}"/>" >
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="name">Category </label>
                                            <select name="catid" class="form-control">
                                                <c:forEach var="c" items="${listCategories}">
                                                    <c:if test="${c.catid eq product.catid}">
                                                        <option value="${c.catid}" selected="">${c.name}</option>
                                                    </c:if>>
                                                    <c:if test="${c.catid ne product.catid}">
                                                        <option value="${c.catid}">${c.name}</option>
                                                    </c:if>>
                                                </c:forEach>
                                            </select>
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="name">Images </label>
                                            <input type="file" class="form-control" name="images" accept="image/*"/>
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-12">
                                        <div class="submit-button text-center">
                                            <button class="btn hvr-hover" type="submit">Update</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Cart -->

        >


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
        <script src="js/profileValidate.js"></script>
    </body>

</html>
