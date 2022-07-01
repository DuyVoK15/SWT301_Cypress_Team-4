<%-- 
    Document   : viewCartPage
    Created on : Feb 11, 2022, 1:34:39 PM
    Author     : user
--%>

<%@page import="java.util.Date"%>
<%@page import="hieu.dao.PlantDao"%>
<%@page import="hieu.dto.Plant"%>
<%@page import="hieu.dao.OrderDao"%>
<%@page import="java.util.HashMap"%>
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
        <section>
            <%
                String name = (String) session.getAttribute("name");
                if (name != null) {
            %>
            <h3>Welcome <%= session.getAttribute("name")%> comback </h3>
            <h3><a href="personalPage.jsp">Personal Page</a></h3>
            <%
                }
            %>
            <font style="color: red; font-size: large"><%= (request.getAttribute("WARNING") == null) ? "" : (String) request.getAttribute("WARNING")%></font>
            <table class="product1">
                <tr><td> Plant id</td>
                    <td> Plant name</td>
                    <td> Price</td>
                    <td> Image</td>
                    <td> Quantity</td>
                    <td> Update</td>
                    <td> Remove</td>
                </tr>
                <%
                    HashMap<String, Integer> cart = (HashMap) session.getAttribute("cart");
                    if (cart != null) {
                        int total = 0;
                        for (String plantID : cart.keySet()) {
                            Plant item = PlantDao.getPlant(Integer.parseInt(plantID));
                %>
                <form action="mainController" method="post">
                    <tr>
                        <td><input type="hidden" value="<%=  item.getPid()%>" name="txtitemid"> <a href="getPlantServlet?txtitemid=<%= item.getPid()%>"><%= item.getPid()%></a></td>
                        <td> <%=  item.getPname()%></td>
                        <td> <%=  item.getPrice()%></td>
                        <td><img src="<%= item.getImgPath()%>" width="100" height="100"></td>
                        <td><input type="number" min="1" max="10" value="<%= cart.get(plantID)%>" name="txtquantity"></td>
                        <td><input type="submit" value="updateQuantity" name="action"></td>
                        <td><input type="submit" value="removeItem" name="action"></td>
                </form>

                <%
                        total = total + item.getPrice() * cart.get(plantID);
                    }
                %>
                <tr><td>Total:  <%= total%> VND</td></tr>
                <tr><td>Order Date:  <%= (new Date()).toString()%> </td></tr>
                <tr><td>Ship Date:  N/A </td></tr>
            </table>
            <section><form action="mainController" method="post">
                    <input type="submit" value="saveOrder" name="action" class="submitorder">
                </form>
            </section>
            <%} else {
            %>
            <h2 style="color: red">Your cart is empty</h2>
            <%
                }
            %>

        </section>

        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
