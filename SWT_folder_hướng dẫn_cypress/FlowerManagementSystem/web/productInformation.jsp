<%-- 
    Document   : productInformation
    Created on : Feb 27, 2022, 6:29:12 PM
    Author     : ADMIN
--%>

<%@page import="hieu.dao.PlantDao"%>
<%@page import="hieu.dto.Plant"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel='stylesheet' href='mycss_1.css' type='text/css' />
    </head>
    <body>
        <%
            String keyword = request.getParameter("txtsearch");
            String searchby = request.getParameter("searchby");
            ArrayList<Plant> list = PlantDao.getPlants(keyword, searchby);
            if (list != null && !list.isEmpty()) {
        %>

        <table>
            <tr><td>Product id</td><td>Name</td><td>Price</td><td>Image</td><td>Detail</td><td>Action</td></tr>
            <% for (Plant plant : list) {
            %>
            <tr>
                <td> <%=plant.getPid()%>  </td>
                <td> <%=plant.getPname()%> </td>
                <td> <%=plant.getPrice()%>  </td>
                <td><img class="image1" src= "<%= plant.getImgPath()%>"/></td>
                <td><a href="#">view detail</a></td>
                <td><a href="mainController?action=addtocart">add to your cart</a></td>
            </tr>
            <%
                }
            %>
        </table>
        <%
        } else {


        %>
        <h1>Not found</h1>
        <a href="index.jsp">Click to back home site</a>
        <%            }
        %>
    </body>
</html>
