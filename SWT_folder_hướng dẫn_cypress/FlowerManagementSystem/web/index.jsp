<%-- 
    Document   : index.jsp
    Created on : Feb 15, 2022, 1:21:10 PM
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
        <link rel="stylesheet" href="mycss_2.css" type="text/css" />
    </head>
    <body>
        <header>
            <%@include file="header.jsp" %>
        </header>
    <session>
        <%
            String keyword = request.getParameter("txtsearch");
            String searchby = request.getParameter("searchby");
            ArrayList<Plant> list;
            String[] tmp = {"out of stock", "availble"};
            if (keyword == null && searchby == null) {
                list = PlantDao.getPlants("", "");
            } else {
                list = PlantDao.getPlants(keyword, searchby);
            }
            if (list != null && !list.isEmpty()) {
                for (Plant p : list) {
                    if (p.getStatus()== 1) {
        %> <table class="product" >
            <tr><td></td><td>ID</td><td>Name</td><td>Price</td><td>Status</td><td>Category</td><td>Action</td></tr>
            <tr >
                <td style="width: 230px" > <img style="border-radius: 50%; width: 200px; height: 200px; margin: 0" src="<%= p.getImgPath()%>" class="plantimg"/></td>
                <td ><%= p.getPid()%> </td> 
                <td><%=p.getPname()%> </td> 
                <td><%=p.getPrice()%> </td>
                <td><%= tmp[p.getStatus()]%> </td>
                <td><%= p.getCatename()%>  </td>
                <td><a href ="mainController?action=addtoCart&pid=<%= p.getPid()%>" style="font-size: small; color: red; font-size: large;">add to cart</a></td>
            </tr>
        </table>

        <% }
                }

            }
        %>
    </session>
    <footer>
        <%@include file="footer.jsp" %>
    </footer>
</body>
</html>
