<%-- 
    Document   : shopping
    Created on : Feb 27, 2017, 2:09:39 PM
    Author     : Lovro
--%>

<%@page import="model.CupcakeFacade"%>
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
        <form name="Cupcakes" action="OrderCake" method="POST">
            <input type="hidden" name="formName" value="shopping"/>
            <%

                String[] toppings = CupcakeFacade.getToppings();
                String[] bottoms = CupcakeFacade.getBottoms();
                 int[] selection = {1,2,3,4,5,6,7,8,9,10};
            %>  
  <div class="container">


            <div class="row">
                <div class="box">
                 <div class="col-lg-12">     
            <table border="1">
                <thead>
                    <tr>
                        <th>Bottom</th>
                        <th>Topping</th>
                        <th>Quantity</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <select name="Bottom">
                                <% for (String b : bottoms) {%>
                                <option><%=b%></option>
                                <%}%>
                            </select>
                        </td>
                        <td>
                            <select name="Topping">
                                <% for (String t : toppings) {%>
                                <option><%=t%></option>
                                <%}%>
                            </select></td>
                            <td>
                                <select name="quantity">
                        <% for (int b : selection) {%>
                        <option><%=b%></option>
                        <%}%>
                    </select>
                            </td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Order" />
                 </div>
                </div>
            </div>
  </div>
        </form>
    </body>
</html>
