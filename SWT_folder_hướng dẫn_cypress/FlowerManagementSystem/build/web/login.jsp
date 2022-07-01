<%-- 
    Document   : login.jsp
    Created on : Mar 16, 2022, 4:56:08 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <%@include file="header.jsp" %>
        </header>
    <session>
         <font style="color: red; font-size: large"><%= (request.getAttribute("WARNING_LOGIN") == null) ? "" : (String) request.getAttribute("WARNING_LOGIN")%></font>
        <form action="mainController" method="post" class="form">
            <table>
                <tr><td>email</td><td><input type="text" name="txtemail"></td></tr>
                <tr><td>password</td><td><input type="text" name="txtpassword"></td></tr>
                <tr><td colspan="2"><input type="submit" value="login" name="action"></td></tr>
                <tr><td colspan="2"><input type="checkbox" name="savelogin" value="savelogin">Stayed signed in</td></tr>
            </table>
            
        </form>
    </session>
    <footer>
        <%@include file="footer.jsp" %>
    </footer>
</body>
</html>
