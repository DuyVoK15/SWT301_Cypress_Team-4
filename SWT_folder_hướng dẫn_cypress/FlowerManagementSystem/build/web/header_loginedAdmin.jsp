<%-- 
    Document   : header_loginedAdmin
    Created on : Mar 21, 2022, 12:50:17 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="mycss_3.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
            <ul>
                <li class="title"><a href="index.jsp">Home</a></li>
                <li class="title"><a href="mainController?action=manageAccounts">Manage Accounts</a></li>
                <li class="title"><a href="mainController?action=manageOrders">Manage Orders</a></li>
                <li class="title"><a href="mainController?action=managePlants">Manage Plants</a></li>
                <li class="title"><a href="mainController?action=manageCategories">Manage Categories</a></li>
                <li>Welcome ${sessionScope.name} | <a href="mainController?action=logout">logout</a></li>

            </ul>
        </header>
    </body>
</html>
