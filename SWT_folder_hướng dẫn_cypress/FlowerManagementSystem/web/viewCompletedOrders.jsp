<%-- 
    Document   : viewCompletedOrders
    Created on : Mar 23, 2022, 10:19:22 AM
    Author     : ADMIN
--%>

<%@page import="hieu.dto.Order"%>
<%@page import="hieu.dao.OrderDao"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <%@include file="header_loginedUser.jsp"%>
        </header>
        <section>
            <h3><a href="mainController?action=logout">Logout</a></h3>
        </section>
        <section>
            <a href="personalPage.jsp">view all order</a>

            <%
                String email = (String) session.getAttribute("email");
                ArrayList<Order> list = OrderDao.getOrders(email);
                String[] status = {"", "processing", "compeleted", "canceled"};
                int count =0;
                if (list != null && !list.isEmpty()) {
                    for (Order ord : list) {
                        if (ord.getStatus() == 2) {
                            count++;
            %>

            <table class="order">
                <tr><td>Order ID</td><td>Order Date</td><td>Ship Date</td><td>Order's Status</td><td>Action</td></tr>
                <tr><td><%= ord.getOrderID()%></td>
                    <td><%= ord.getOrdDate()%></td>
                    <td><%= ord.getShipdate()%></td>
                    <td><%= status[ord.getStatus()]%></td>
                    <td><a href="OrderDetail.jsp?orderid=<%= ord.getOrderID()%>">detail</a></td>
                </tr>
            </table>

            <% }
                }
            }  if(count == 0) {
            %>
            <p>you don't have any order</p>
            <%
                }
            %>
        </section>


        <footer>
            <%@include file="footer.jsp" %>
        </footer>    
    </body>
</html>
