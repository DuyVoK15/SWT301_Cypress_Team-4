<%-- 
    Document   : header_loginedUser.jsp
    Created on : Feb 17, 2022, 10:18:33 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="mycss_2.css" type="text/css" />
        <link href="mycss_2.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav>
            <ul>
                <li><a href="index.jsp">Home</li>
                <li><a href="mainController?action=changeprofile">Change profile</li>
                <li><a href="viewCompletedOrders.jsp">Completed orders</li>
                <li><a href="viewCanceledOrders.jsp">Canceled orders</li>
                <li><a href="viewProcessingOrders.jsp">Processing orders</li>
                <li>form<input type="date" name="form">to<input type="date" name="to"><input type="submit" value="search"></li>

            </ul>
        </nav>
    </body>
</html>
