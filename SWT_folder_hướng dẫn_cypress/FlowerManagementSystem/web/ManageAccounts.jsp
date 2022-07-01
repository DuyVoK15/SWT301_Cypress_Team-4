<%-- 
    Document   : ManageAccounts
    Created on : Mar 21, 2022, 1:23:31 PM
    Author     : ADMIN
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="hieu.dao.AccountDao"%>
<%@page import="hieu.dto.Account"%>
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
                    <option value="byemail">By email</option><option value="byusername">By user name</option>
                </select>
                <input type="submit" value="searchAccount" name="action" >
            </form>
        <h1></h1>

        <table class="order">
            <tr><th> ID</th>
                <th> Email</th>
                <th> Full name</th>
                <th> Status</th>
                <th> Phone</th>
                <th> Role</th>
                <th> Action</th>
            </tr>
        <c:forEach var="acc" items="${requestScope.accountlist}">
            <tr><td><c:out value="${acc.getAccId()}"></c:out></td>
                <td><c:out value="${acc.getEmail()}"></c:out></td>
                <td><c:out value="${acc.getFullname()}"></c:out></td>
                <td><c:choose >
                        <c:when test="${acc.getStatus() eq 1}"> active</c:when>
                        <c:otherwise>inActive</c:otherwise>
                    </c:choose>
                </td>
                <td><c:out value="${acc.getPhone()}"></c:out></td>
                    <td>
                    <c:choose>
                        <c:when test="${acc.getRole() eq 1}">Admin</c:when>
                        <c:otherwise>user</c:otherwise>
                    </c:choose>
                </td>
                <td><c:if test="${acc.getRole() eq 0}">
                        <c:url var="mylink" value="mainController">
                            <c:param name="accid" value="${acc.getAccId()}"></c:param>
                            <c:param name="status" value="${acc.getStatus()}"></c:param>
                            <c:param name="action" value="updateStatusAccounts"></c:param>
                        </c:url>
                        <a href="${mylink}">Block/UnBlock</a>
                    </c:if></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
