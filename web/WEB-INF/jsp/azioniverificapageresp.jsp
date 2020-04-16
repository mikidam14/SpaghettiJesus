<%-- 
    Document   : azioniverificapageresp
    Created on : Apr 16, 2020, 6:38:55 PM
    Author     : michele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu azioni di verifica</title>
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
        <div id="center"><h2>AZIONI DI VERIFICA</h2></div>
        <div id="center">
            <c:if test="${!empty azioniverifica}">
                <table>
                    <tr style="background-color: cornflowerblue">
                        <th>Id</th>
                        <th>Descrizione</th>
                        <th>Utente</th>
                        <th>AzCr</th>
                    </tr>
                <c:forEach items="${azioniverifica}" var="av">
                    <tr style="background-color: lightcyan">
                        <td>${av.id}</td>
                        <td>${av.descrizione}</td>
                        <td>${av.utente.username}</td>
                        <td>${av.azCr.id}</td>
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
