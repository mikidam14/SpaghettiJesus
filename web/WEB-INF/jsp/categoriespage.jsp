<%-- 
    Document   : page
    Created on : Feb 5, 2020, 1:45:18 PM
    Author     : michele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorie</title>
        <style>
            table{
                border-collapse: collapse;
            }
            table, th, tr, td {
                border: solid black 1px;
                padding: 5px;
            }
        </style>
    </head>
    <body>
        <div align="center"><h2>Cateogorie disponibili</h2></div>
        <c:if test="${!empty categories}">
            <table align="center">
                <tr style="background-color: cornflowerblue">
                    <th width="100">Nome</th>
                    <th width="500">Descrizione</th>
                    <th></th>
                </tr>
            <c:forEach items="${categories}" var="cat">
                <tr style="background-color: lightcyan">
                    <td>${cat.name}</td>
                    <td>${cat.description}</td>
                    <td><a href="<c:url value='/showevents/${cat.id}'/>">Visualizza eventi</td>
                </tr>
            </c:forEach>
            </table>
        </c:if>
    </body>
</html>
