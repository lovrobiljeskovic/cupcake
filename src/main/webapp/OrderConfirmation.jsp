<%-- 
    Document   : OrderConfirmation
    Created on : Feb 28, 2017, 9:21:21 AM
    Author     : Lovro
--%>

<%@page import="model.Cupcake"%>
<%@page import="model.OrderLine"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Contact - Business Casual - Start Bootstrap Theme</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/business-casual.css" rel="stylesheet">

        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    <body>
          <nav class="navbar navbar-default" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
                    <a class="navbar-brand" href="index.html">Business Casual</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="index.jsp">Home</a>
                    </li>
                    <li>
                        <a href="newCustomer.jsp">Register</a>
                    </li>
                    <li>
                        <a href="login.jsp">Login</a>
                    </li>
                    <li>
                        <a href="shopping.jsp">Shop</a>
                    </li>
                </ul>
            </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>
           <% Cupcake cupcake = (Cupcake)request.getAttribute("cupcake"); %>
        <% String bottomName = cupcake.getBottom().getName(); %>
        <% String toppingName = cupcake.getTopping().getName(); %>
        <% double totalPrice =  (double)request.getAttribute("totalPrice"); %>
           <div class="container">


            <div class="row">
                <div class="box">
                    
          <div class="col-lg-12">
        <hr>
        <h1 class="intro-text text-center">Your Order</h1>     
        <p>Topping: <%=toppingName%></p>
          <p>Bottom: <%=bottomName%></p>
           <p>You ordered  <%= request.getAttribute("totalQuantity") %> <%= bottomName %> and <%= toppingName  %> cupcakes </p>
            <p>Your total price:  £<%= totalPrice %> </p>
          </div>
                </div>
            </div>
           </div>
    </body>
</html>
