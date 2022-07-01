<%-- 
    Document   : viewPlant
    Created on : Mar 21, 2022, 11:34:26 AM
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
        <jsp:useBean id="plantObj" class="hieu.dto.Plant" scope="request"/>
        <header>
            <%@include file="header.jsp" %>
        </header>
        <table class="plant">
            <tr><td rowspan="8"style="width: 230px" > <img style="border-radius: 50%; width: 200px; height: 200px; margin: 0" src="<jsp:getProperty name="plantObj" property="imgPath"></jsp:getProperty>"></td></tr>
            <tr><td>Id:<jsp:getProperty name="plantObj" property="pid"></jsp:getProperty></td></tr>
            <tr><td>Product name:<jsp:getProperty name="plantObj" property="pname"></jsp:getProperty></td></tr>
            <tr><td>Price:<jsp:getProperty name="plantObj" property="price"></jsp:getProperty></td></tr>
            <tr><td>Description:<jsp:getProperty name="plantObj" property="description"></jsp:getProperty></td></tr>
            <tr><td>Status:<jsp:getProperty name="plantObj" property="status"></jsp:getProperty></td></tr>
            <tr><td>C\ate id:<jsp:getProperty name="plantObj" property="cateID"></jsp:getProperty></td></tr>
            </table>

            <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>

