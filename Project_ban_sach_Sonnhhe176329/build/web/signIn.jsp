<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%
    String check = (String)request.getAttribute("check");
%>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" 
              integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

        <!-- Style -->
        <link rel="stylesheet" href="css/signIn.css">

        <title>Login</title>
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
                                <form action="signin" method="post">
                                    <div class="form-group">

                                        <input type="text" class="form-control" placeholder="Username" id="username" name="user" required="">
                                    </div>
                                    <div class="form-group">

                                        <input type="password" class="form-control" placeholder="**********" id="password" name="pass" required="">
                                    </div>

                                    <div class="d-sm-flex mb-5 align-items-center">
                                        <label class="control control--checkbox mb-3 mb-sm-0"><span class="caption">Remember me</span>
                                            <input type="checkbox"/>
                                            <div class="control__indicator"></div>
                                        </label>
                                        <span class="ml-auto"><a href="signup" class="forgot-pass">Sign Up</a></span> 
                                    </div>

                                    <c:choose>
                                        <c:when test="${check.equals('success')}">
                                            ${'Success'}
                                            <c:redirect url="home"/>
                                            <br />
                                        </c:when>
                                        <c:when test="${check.equals('fail')}">
                                            ${'<span class="badge badge-danger">Invalid Username or Password</span> <br/>'}
                                        </c:when>
                                        <c:otherwise>
                                            <br />
                                        </c:otherwise>
                                    </c:choose>
                                            
                                            <input type="submit" value="Log In" class="btn btn-block btn-outline-danger" id="btn-primary"> 
                                    
                                    
                                    <span class="ml-auto"><a href="home" class="forgot-pass">Back to Home</a></span> 

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>



        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
