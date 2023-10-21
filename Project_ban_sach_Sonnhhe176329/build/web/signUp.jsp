<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

<!--        <link rel="stylesheet" href="fonts/icomoon/style.css">-->

        <link rel="stylesheet" href="css/owl.carousel.min.css">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" 
              integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

        <!-- Style -->
        <link rel="stylesheet" href="css/signIn.css">
        <link rel="stylesheet" href="css/signUp.css">

        <title>Register</title>
    </head>
    <body>


        <div class="half">
            <div class="bg order-1 order-md-2" style="background-image: url('images/banner-01.jpg');"></div>
            <div class="contents order-2 order-md-1">

                <div class="container">
                    <div class="row align-items-center justify-content-center">
                        <div class="col-md-6">
                            <div class="form-block">
                                <div class="text-center mb-5">
                                    <h3>Login to <strong>Shop</strong></h3>
                                    <!-- <p class="mb-4">Lorem ipsum dolor sit amet elit. Sapiente sit aut eos consectetur adipisicing.</p> -->
                                </div>
                                <form class="register-form" name="register-form" action="signup" method="post" onsubmit="return validateForm()">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="username" id="username" placeholder="Username" required="">
                                        <div class="badge badge-danger" id="userFail"></div>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="fullname" id="fullname" placeholder="Fullname" required="">
                                        <div class="badge badge-danger" id="fullnameFail"></div>
                                    </div>
                                    <div class="form-group">
                                        <input type="email" class="form-control" name="email" id="email" placeholder="Email" required="">
                                        
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="phone" id="phone" placeholder="Phone number" required="">
                                        <div class="badge badge-danger" id="phoneFail"></div>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="address" id="address" placeholder="Address" required="">
                                        
                                    </div>
                                    <div class="row md-12">
                                        <div class="form-group col-md-6">
                                            <input type="password" class="form-control" name="password" id="password" placeholder="Password" required="">
                                            <div class="help-block with-errors"></div>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <input type="password" class="form-control" name="repassword" id="repassword" placeholder="Re-password" required="">
                                            <div class="badge badge-danger" id="repassFail"></div>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-block btn-outline-danger submit"> Register </button>
                                    <span class="ml-auto"><a href="signin" class="forgot-pass">Login</a></span> 
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>



        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
<!--        <script src="js/main.js"></script>-->
        <script src="js/signupValidate.js"></script>
    </body>
</html>
