<%-- 
    Document   : ManagePlants
    Created on : Mar 22, 2022, 7:51:18 PM
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
                    <option value="byname">By Plant Name</option><option value="bycate">By Category</option>
                </select>
                <input type="submit" value="searchPlant" name="action">
            </form>
            <h1></h1>
            <table class="plant">
                <tr><th>Plant ID</th>
                    <th>Plant name</th>
                    <th>Price</th>
                    <th></th>
                    <th>Description</th>
                    <th>Status</th>
                    <th>Category ID</th>
                    <th>Category name</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>

            <c:forEach var="plant" items="${requestScope.plantslist}">
                <form action="mainController" method="post">
                    <tr>
                        <td><input type="text" name="PID" value="<c:out value="${plant.getPid()}"></c:out>" readonly=""></td>
                        <td><input type="text" name="pname" value="<c:out value="${plant.getPname()}"></c:out>"></td>
                        <td><input type="text" name="price" value="<c:out value="${plant.getPrice()}"></c:out>"></td>
                        <td><img class="image" src="${plant.getImgPath()}"></td>
                        <td><input type="text" name="description" value="<c:out value="${plant.getDescription()}"></c:out>"></td>
                        <td><input type="text" name="status" value="<c:out value="${plant.getStatus()}"></c:out>" readonly=""></td>
                        <td><input type="text" name="cateid" value="<c:out value="${plant.getCateID()}"></c:out>"></td>
                        <td><input type="text" name="catename" value="<c:out value="${plant.getCatename()}"></c:out>" readonly=""></td>
                            <td>
                                <input type="submit" name="action" value="updatePlant">
                            </td>
                            <td>
                            <c:if test="${plant.getStatus() eq 1}">
                                <input type="submit" name="action" value="deletePlant">
                            </c:if>
                            <c:if test="${plant.getStatus() eq 0}">
                                <input type="submit" name="action" value="restore">
                            </c:if>
                        </td>


                    </tr>
                </form>
            </c:forEach>
            <form action="mainController" method="post">
                <tr>
                    <td></td>
                    <td><input type="text" name="newpname" placeholder="plant name"></td>
                    <td><input type="text" name="newprice" placeholder="price"></td>
                    <td><input type="text" name="newimgpath" placeholder="image path"></td>
                    <td><input type="text" name="newdescription" placeholder="description"></td>
                    <td><input type="text" name="newstatus" placeholder="status"></td>
                    <td><input type="text" name="newcateid" placeholder="category ID"></td>
                    <td></td>
                    <td><input type="submit" name="action" value="insertplant"></td>
                </tr>
            </form>
        </table>
    </body>
</html>
