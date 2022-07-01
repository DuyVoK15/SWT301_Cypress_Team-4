<%-- 
    Document   : ManageCategories
    Created on : Mar 23, 2022, 10:53:03 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="header_loginedAdmin.jsp"></c:import>

            <form action="mainController" method="post" class="formsearch">
                <input type="text" name="txtsearch" class="searchbar">
                <select name="searchby">
                    <option value="cateID">By cate ID</option><option value="cateName">By category name</option>
                </select>
                <input type="submit" value="searchCate" name="action">
            </form>
            <h1></h1>
            <table class="order">
                <tr><th>Category ID</th>
                    <th>Category name</th>
                </tr>

            <c:forEach var="cate" items="${requestScope.catelist}">
                <form action="mainController" method="post">
                    <tr>
                        <td><input type="text" name="cateID" value="<c:out value="${cate.getCateID()}"></c:out>" readonly=""></td>
                        <td><input type="text" name="cateName" value="<c:out value="${cate.getCateName()}"></c:out>"></td>
                        <td><input type="submit" name="action" value="updatecate"></td>
                        </tr>
                    </form>
                    
                </c:forEach>
            <form action="mainController" method="post">
                <tr>
                    <td></td>
                    <td><input type="text" name="newcatename" placeholder="Category name"></td>
                    <td><input type="submit" name="action" value="insetCategory"></td>
                </tr>
            </form>
        </table>   
    </body>
</html>
