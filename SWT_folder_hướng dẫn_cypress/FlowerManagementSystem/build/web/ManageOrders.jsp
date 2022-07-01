<%-- 
    Document   : ManageOrders
    Created on : Mar 22, 2022, 3:13:37 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="mycss_4.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <c:import url="header_loginedAdmin.jsp"></c:import>

            <form action="mainController" method="post" class="formsearch">
                <input type="text" name="txtsearch" class="searchbar">
                <select name="searchby">
                    <option value="byorderID">By ID</option><option value="byaccID">By user ID</option>
                </select>
                <input type="submit" value="searchOrder" name="action">
            </form>
            <h1></h1>
            <table class="order">
                <tr><th>OrderID</th>
                    <th>Order Date</th>
                    <th>Ship Date</th>
                    <th>Status</th>
                    <th>Acccount ID</th>
                    <th>Cancel Order</th>
                    <th>Complete Order</th>
                </tr>

            <c:forEach var="ord" items="${requestScope.orderslist}">
                <form action="mainController" method="post">
                    <tr>
                        <td><input type="text" name="ordID" value="<c:out value="${ord.getOrderID()}"></c:out>" readonly=""></td>
                        <td><input type="text" name="ordDate" value="<c:out value="${ord.getOrdDate()}"></c:out>" readonly=""></td>
                        <td><input type="text" name="shipDate" value="<c:out value="${ord.getShipdate()}"></c:out>"></td>
                        <td hidden=""><input type="text" name="status" value="<c:out value="${ord.getStatus()}"></c:out>"></td>
                        <td><c:choose >
                                <c:when test="${ord.getStatus() eq 1}">Processing</c:when>
                                <c:when test="${ord.getStatus() eq 2}">Compeleted</c:when>
                                <c:otherwise>Canceled</c:otherwise>
                            </c:choose>
                        </td>
                        <td><input type="text" name="accId" value="<c:out value="${ord.getAccID()}"></c:out>"></td>
                        <td><c:if test="${ord.getStatus() eq 1}">
                                <c:url var="mylink" value="mainController">
                                    <c:param name="orderid" value="${ord.getOrderID()}"></c:param>
                                    <c:param name="status" value="${ord.getStatus()}"></c:param>
                                    <c:param name="action" value="cancelOrder"></c:param>
                                </c:url>
                                <a href="${mylink}">Cancel Order</a>
                            </c:if>
                            <c:if test="${ord.getStatus() eq 3}">
                                <c:url var="mylink2" value="mainController">
                                    <c:param name="orderid" value="${ord.getOrderID()}"></c:param>
                                    <c:param name="status" value="${ord.getStatus()}"></c:param>
                                    <c:param name="action" value="cancelOrder"></c:param>
                                </c:url>
                                <a href="${mylink2}">ReOrder</a>
                            </c:if></td>
                        <td><c:if test="${ord.getStatus() eq 1}">
                                <input type="submit" name="action" value="completeOrder">
                            </c:if></td>
                    </tr>
                </form>
            </c:forEach>
        </table>
    </body>
</html>
