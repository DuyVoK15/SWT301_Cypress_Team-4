<%-- 
    Document   : header
    Created on : Feb 15, 2022, 1:15:12 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="mycss_2.css" type="text/css" />

    </head>
    <body>
        <header>
            <nav>
                <ul>
                    <li><a href=""><img class="image" src="images/logo.jpg"></a> </li>
                    <li class="title"><a  href="index.jsp">Home</a></li>
                    <li class="title"><a href="registration.html">Register</a></li>
                    <li class="title"><a href="mainController?action=logout" >Logout</a></li>
                    <li class="title"><a href="mainController?action=viewcart" >View Cart</a></li>
                    <li class="title"><a href="mainController?action=viewOrders" >View Orders</a></li>
                    <li class="title"><form action="mainController" method="post" class="formsearch">
                            <input type="text" name="txtsearch">
                            <select name="searchby">
                                <option value="byname">by name</option><option value="bycate">by category</option>
                            </select>
                            <input type="submit" value="search" name="action" >
                        </form></li>
                </ul>
            </nav>
        </header>
    </body>
</html>
