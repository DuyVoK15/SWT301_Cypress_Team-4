<%-- 
    Document   : changeProfile
    Created on : Mar 23, 2022, 9:43:15 AM
    Author     : ADMIN
--%>

<%@page import="hieu.dto.Account"%>
<%@page import="hieu.dao.AccountDao"%>
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


            <%
                String email = (String) session.getAttribute("email");
                Account acc = AccountDao.getAccounts(email);
            %>
             <font style="color: red; font-size: large"><%= (request.getAttribute("REPORT") == null) ? "" : (String) request.getAttribute("REPORT")%></font>
            <table class="profile">
                <form action="mainController" method="post">
                    <tr><td>Full name: <input type="text" name="newFullname" value="<%= acc.getFullname()%>"></td></tr>
                    <tr><td>Email: <input type="text" name="newemail" value="<%= acc.getEmail()%>" readonly=""></td></tr>
                    <tr><td>Password: <input type="text" name="newpassword" value="*********"></td></tr>
                    <tr><td>Phone number: <input type="text" name="newPhone" value="<%= acc.getPhone()%>"></td></tr>
                    <tr><td><input type="submit" value="Change" name="action"></td></tr>
                </form>

            </table>
        </section>
    </body>
</html>
