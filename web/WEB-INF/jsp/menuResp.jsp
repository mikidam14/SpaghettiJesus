<%-- 
    Document   : menuResp
    Created on : Apr 3, 2020, 4:26:13 PM
    Author     : michele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
        <h1>Hello Responsabile</h1>
        <h2>SEGNALAZIONI</h2>
        <c:if test="${!empty segnalazioni}">
            <table>
                <tr style="background-color: cornflowerblue">
                    <th>Id</th>
                    <th>Data</th>
                    <th>Descrizione</th>
                    <th>Prodotto</th>
                    <th>Utente</th>
                    <th>Settore</th>
                </tr>
            <c:forEach items="${segnalazioni}" var="se">
                <tr style="background-color: lightcyan">
                    <td>${se.id}</td>
                    <td>${se.data}</td>
                    <td>${se.descrizione}</td>
                    <td>${se.prodotto}</td>
                    <td>${se.utente.username}</td>
                    <td>${se.settore.nome}</td>
                    <td><a href="<c:url value='/removeSe/${se.id}' />" >Chiudi segnalazione.</a></td>
                </tr>
            </c:forEach>
            </table>
        </c:if>
        
        <h2>NON CONFORMITÀ</h2>
        
        <h2>AZIONI DI VERIFICA</h2>
    </body>
</html>
