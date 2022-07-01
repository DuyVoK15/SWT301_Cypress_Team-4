<%-- 
    Document   : personalPage.jsp
    Created on : Feb 17, 2022, 10:18:45 AM
    Author     : ADMIN
--%>

<%@page import="hieu.dao.AccountDao"%>
<%@page import="hieu.dto.Account"%>
<%@page import="hieu.dto.Order"%>
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
        <%
            String name = (String) session.getAttribute("name");
            String email = (String) session.getAttribute("email");
            Cookie[] c = request.getCookies();
            boolean login = false;
            if (name == null) {
                String token = "";
                for (Cookie aCookie : c) {
                    if (aCookie.getName().equals("selector")) {
                        token = aCookie.getValue();
                        Account acc = AccountDao.getAccounts(token);
                        if (acc != null) {
                            name = acc.getFullname();
                            email = acc.getEmail();
                            login = true;
                        }
                    }
                }
            } else {
                login = true;
            }
            if (login) {
        %>
        <header>
            <%@include file="header_loginedUser.jsp"%>
        </header>
        <section>
            <h3>Welcome <%= name%> come back</h3>
            <h3><a href="mainController?action=logout">Logout</a></h3>

        </section>
        <font style="color: red; font-size: large"><%= (request.getAttribute("REPORT_CANCEL") == null) ? "" : (String) request.getAttribute("REPORT_CANCEL")%></font>
        <section>
            <%
                ArrayList<Order> list = OrderDao.getOrders(email);
                String[] status = {"", "processing", "compeleted", "canceled"};
                if (list != null && !list.isEmpty()) {
                    for (Order ord : list) {%>
            <table class="order">
                <tr><td>Order ID</td><td>Order Date</td><td>Ship Date</td><td>Order's Status</td><td>Action</td></tr>
                <tr><td><%= ord.getOrderID()%></td>
                    <td><%= ord.getOrdDate()%></td>
                    <td><%= ord.getShipdate()%></td>
                    <td><%= status[ord.getStatus()]%>
                        <br/><% if (ord.getStatus() == 1)%><a href="mainController?action=cancelorderforuser&orderid=<%= ord.getOrderID()%>">Cancel order</a>
                    </td>
                    <td><a href="OrderDetail.jsp?orderid=<%= ord.getOrderID()%>">detail</a></td>
                </tr>
            </table>

            <% }
            } else {
            %>
            <p>you don't have any order</p>
            <%
                }
            %>
        </section>


        <footer>
            <%@include file="footer.jsp" %>
        </footer>
        <%
            } else {
                request.setAttribute("WARNING_LOGIN", "You must login first");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }


        %>

    </body>
</html>
