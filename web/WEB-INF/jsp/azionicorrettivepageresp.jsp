<%-- 
    Document   : azionicorretivepageresp
    Created on : Apr 16, 2020, 6:30:48 PM
    Author     : michele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu azioni correttive</title>
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
        <div id="center"><h2>AZIONI CORRETTIVE</h2></div>
        <div id="center">
            <c:if test="${!empty azionicorrettive}">
                <table>
                    <tr style="background-color: cornflowerblue">
                        <th>Id</th>
                        <th>Descrizione</th>
                        <th>Data</th>
                        <th>Team</th>
                        <th>Segnalazione</th>
                    </tr>
                <c:forEach items="${azionicorrettive}" var="ac">
                    <tr style="background-color: lightcyan">
                        <td>${ac.id}</td>
                        <td>${ac.descrizione}</td>
                        <td>${ac.data}</td>
                        <td>${ac.team.nome}</td>
                        <td>${ac.segnalazione.id}</td>
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
