<%-- 
    Document   : segnalazionipage
    Created on : Apr 16, 2020, 6:32:28 PM
    Author     : michele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu segnalazioni</title>
        <style>
            #center{
                display: flex; 
                justify-content:center;
            }
            table {
                border-collapse: collapse;
            }
            
            td{
                text-align: center;
                padding: 5px;
            }
            
            table, th, td {
                border: 1px solid black;
            }
            
            #btns { 
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div id="center"><h2>SEGNALAZIONI</h2></div>
        <div id="center">
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
                        <td><a href="<c:url value='/apriAzioneCorrettiva/${se.id}' />" >Assegna azione correttiva.</a></td>
                    </tr>
                </c:forEach>
                </table>
            </c:if>
        </div>
        <div id="btns">
            <br/>
            <form:form method="post" action="backtout">
                    <button type="submit">Indietro</button>
            </form:form>
        </div>
    </body>
</html>
