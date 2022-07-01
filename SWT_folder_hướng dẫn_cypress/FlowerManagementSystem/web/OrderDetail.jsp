<%-- 
    Document   : newjsp
    Created on : Feb 18, 2022, 1:11:55 PM
    Author     : ADMIN
--%>

<%@page import="hieu.dto.OrderDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hieu.dao.OrderDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="mycss.css" type="text/css" />

    </head>
    <body>

        <header>
            <%@include file="header_loginedUser.jsp"%>
        </header>
        <section>
            <h3>Welcome <% session.getAttribute("name"); %> come back</h3>
            <h3><a href="mainController?action=logout">Logout</a></h3>
            <a href="personalPage.jsp">view all order</a>

        </section>
        <section>
            <%  String orderid = request.getParameter("orderid");
                if (orderid != null) {
                    int orderID = Integer.parseInt(orderid.trim());
                    ArrayList<OrderDetail> list = OrderDao.getOrderDetail(orderID);
                    if (list != null && !list.isEmpty()) {
                        int money = 0;
                        for (OrderDetail detail : list) {%>
            <table class="order" >
                <tr><td>Order ID</td><td>Plant ID</td><td>Plant Name</td><td>Image</td><td>Quantity</td></tr>
                <tr><td><%= detail.getOrderID()%></td>
                    <td><%= detail.getPlantID()%></td>
                    <td><%= detail.getPlantName()%></td>
                    <td><img src= "<%= detail.getImgpath()%>" class="plantimg"/> <br/> <%= detail.getPrice()%></td>
                    <td><%= detail.getQuantity()%></td>
                    <% money = money + detail.getPrice() * detail.getQuantity(); %>
                </tr>

            </table>   
            <%    }%>
            <h3> Total money: <%= money%></h3>
            <%
            } else {
            %>
            <p>You don't have any order</p>
            <%
                    }
                }
            %>

        </section>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
